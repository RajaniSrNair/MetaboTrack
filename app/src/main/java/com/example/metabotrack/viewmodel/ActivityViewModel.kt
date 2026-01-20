import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ActivityViewModel(private val repository: ActivityRepository) : ViewModel() {

    private val _activityMet = MutableStateFlow<Double?>(null)
    val activityMet: StateFlow<Double?> = _activityMet

    val activities = repository.getAllActivities() // Live updates

    fun fetchActivityMet(activityName: String) {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getActivityMet(activityName)
                _activityMet.value = response.met
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun saveActivity(name: String, met: Double, durationMinutes: Int, weightKg: Double) {
        val calories = met * weightKg * (durationMinutes / 60.0)
        val activity = ActivityEntity(
            name = name,
            met = met,
            durationMinutes = durationMinutes,
            calories = calories
        )
        viewModelScope.launch {
            repository.insertActivity(activity)
            AuthHelper.currentUser?.uid?.let { userId ->
                FirestoreHelper.saveActivity(userId, activity)
            }
        }

    }
}
