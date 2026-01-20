package com.example.metabotrack.ui

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Use coroutine for Firebase login
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    AuthHelper.signIn(email, password)
                    withContext(Dispatchers.Main) { onLoginSuccess() }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) { errorMessage = e.message }
                }
            }
        }) {
            Text("Login")
        }
        errorMessage?.let { Text(it, color = MaterialTheme.colorScheme.error) }
    }
}
