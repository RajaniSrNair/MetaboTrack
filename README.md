# MetaboTrack 🏃‍♂️🔥  
**Human Energy Expenditure Tracking Application (Android)**

MetaboTrack is an Android application designed to help users track **energy consumption (calories burned)** during various physical activities. The app combines **local persistence**, **cloud authentication**, and **external API-based metabolic calculations** to provide accurate and personalized insights.

This project is developed as part of an academic Android development submission and follows **modern Android architecture best practices**.

---

## 🚀 Features

- 🔐 User Authentication using **Firebase Authentication**
- 📊 Activity-based calorie tracking
- 🧠 Energy expenditure calculation using **MET-based external API**
- 💾 Local data storage using **Room Database**
- ☁️ Cloud-ready architecture with Firebase
- 🎨 Modern UI built with **Jetpack Compose**
- 🧩 Clean architecture using **MVVM**
- 🔄 Navigation using **Jetpack Navigation Compose**

---

## 🏗️ Architecture Overview

The application follows **MVVM (Model–View–ViewModel)** architecture.

UI (Compose Screens)
↓
ViewModel
↓
Repository
↓
Room Database / Firebase / External API

### Key Components
- **ViewModel** – Handles business logic and UI state
- **Repository** – Single source of truth for data
- **Room** – Offline-first local persistence
- **Firebase** – Authentication and user management
- **API Layer** – Calorie calculation using MET values

---

## 🛠️ Tech Stack

| Category | Technology |
|-------|-----------|
| Language | Kotlin |
| UI | Jetpack Compose |
| Architecture | MVVM |
| Local Storage | Room Database |
| Authentication | Firebase Auth |
| Networking | Retrofit |
| Navigation | Navigation Compose |
| Dependency Injection | Hilt (if used) |
| Build System | Gradle |

---

## 🔌 External API Integration

### 🔍 API Purpose
The API is used to calculate **calories burned** based on:
- Activity type
- Duration
- User weight
- MET (Metabolic Equivalent of Task) values

### 🧮 Example Formula Used
Calories Burned = MET × Weight (kg) × Duration (hours)

### 🌐 Example APIs
- **Ninja Calories API**
- **API Ninjas – Calories Burned**
- **MET Activity Dataset (public fitness APIs)**

###  🔌 External API Integration – CalorieNinjas
🌐 API Overview

MetaboTrack integrates with the CalorieNinjas Calories Burned API to retrieve accurate energy expenditure (calories burned) for human physical activities.

API Provider: CalorieNinjas

Base URL: https://api.calorieninjas.com/v1/calories

Query Format: https://api.calorieninjas.com/v1/calories?query=<activity>

🔑 Authentication

The API requires an API key to be passed via the HTTP request header.

> The app fetches MET values dynamically and computes energy expenditure accurately instead of using hardcoded values.

---

## 🔐 Firebase Integration

- **Firebase Authentication**
  - Email & Password Sign-in
- Secure user-specific activity tracking
- Ready for future cloud sync features

---

## 📂 Project Structure

com.example.metabotrack
│
├── ui
│ ├── welcome
│ ├── login
│ ├── addactivity
│ └── list
│
├── viewmodel
│
├── data
│ ├── local (Room)
│ ├── remote (API)
│ └── repository
│
├── navigation
└── utils

---

## ▶️ How to Run

1. Clone the repository
2. Open in **Android Studio**
3. Add Firebase configuration:
   - `google-services.json`
4. Add API key in `local.properties`
5. Sync Gradle and run on emulator or device

---

## 🎓 Academic Use

- Demonstrates:
  - Android app architecture
  - Database persistence
  - API integration
  - Firebase authentication
- Suitable for:
  - Android development coursework
  - Capstone / final projects
  - Portfolio showcase

---

## 📌 Future Enhancements

- Cloud sync of activities
- User profile & BMI calculation
- Charts and analytics dashboard
- Wearable integration

---

## 👩‍💻 Author

**Rajani S R Nair**  
📍 Toronto, Canada

---

## 📄 License

This project is intended for **educational purposes**.
