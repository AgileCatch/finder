# Project 13조 - Finder

## 🥨 **프로젝트 소개**
Finder는 **YouTube의 원하는 영상을 검색**하고 즐길 수 있는 어플리케이션입니다.   
키워드 검색, 인기 동영상, 카테고리 별 영상을 통해  여러분의 취향에 맞는 콘텐츠를 찾을 수 있습니다. 


## 🎲 **기간 및 기여도**

**기간** : 23.09.25 ~ 23.10.5 `2주`

**참여 인원** : `4명`

**기여도 : `30%`**

---

💡**이런 기능이 있어요**

```

1. 영상 검색

- 키워드만 가지고 영상을 검색하고 원하는 순서대로 정렬할 수 있습니다.

2. 북마크로 관심있는 영상 저장!

- 관심있는 영상을 마이 페이지에 저장 할 수 있습니다.

3. 인기 영상, 카테고리별 영상 추천!

- 메인 페이지에서 인기순위대로 동영상을 추천해주고 , 카테고리별로 영상을 나눠볼 수 있습니다.

```

---

## ⚙️ **내가 사용한 기술 스택**
<img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat-square&logo=Kotlin&logoColor=white"/> <img src="https://img.shields.io/badge/AndroidStudio-3DDC84?style=flat-square&logo=AndroidStudio&logoColor=white"/>
<img src="https://img.shields.io/badge/git-F05032?style=flat-square&logo=git&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=flat-square&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/notion-000000?style=flat-square&logo=notion&logoColor=white">
<img src="https://img.shields.io/badge/slack-4A154B?style=flat-square&logo=slack&logoColor=white">
<img src="https://img.shields.io/badge/figma-F24E1E?style=flat-square&logo=figma&logoColor=white">

- Kotlin
- Retrofit
- SharedPreference
- ViewPager2
- Infinity Scroll
- YouTube API
- Glide
- Dialog Fragment
- MVVM

---
  
## 📱 **와이어프레임**

<img width="635" alt="finder_wirframe" src="https://github.com/Android-Team-13-Maniacs/android_project_maniacs/assets/106515742/5327e78c-5ff9-4bde-b93b-9d53fdd1b29b">

</br>

## 💪🏻 **주요 역할**

---

- **MVVM 디자인 패턴 적용** 하여 유지보수성 향상
- **ViewPager2 와 Tablayout 을사용**해 3개의 Fragment로 분리하여 팀원이 함께 작업할 수 있도록 구현
- Figma를 사용하여 앱의 전반적인 **UI/UX** 담당
    - **HomeFragment**
        - **인기 동영상 인디케이터** 및 **자동 스크롤 구현** 하여 UX 향상
        - **Spinner**와 **RecyclerView**를 사용하여 Video Item이 화면에 보여지도록 구현
        - RecyclerView의 Video item 클릭 시 데이터가 전달되며 디테일 Activity로 화면 전환
    - **MyVideoFragment**
        - **UX 향상**을 위해 갤러리에서 사진을 가져오기위 해 **권한 허용 로직** 구현
        - **SharedPreferences를 사용**해 앱내에 프로필과 닉네임을 저장할 수 있도록 구현
    - **SearchFragment**
        - **UX향상**을 위해 FAB buttoon 부착하여 버튼 클릭시 최상단으로 올리도록 구현
        - **Glide를 사용**해 대용량 image를 쉽게 처리 할 수 있도록 구현

---

## 👩🏻‍💻 **구현한 페이지 및 구현과정**

### **1) HomeFragment**

<img width="200" alt="home" src="https://github.com/AgileCatch/finder/assets/106515742/222247fd-2a4f-49db-ab42-89d535513d4d">

### **2) SearchFragment**

<img width="200" alt="finder1" src="https://github.com/Android-Team-13-Maniacs/android_project_maniacs/assets/106515742/ad55c86f-99da-43c1-9b17-811ef87eb456"><img width="200" alt="finder5" src="https://github.com/Android-Team-13-Maniacs/android_project_maniacs/assets/106515742/a3a1cf8c-cdf2-4b96-9c48-3cfdeb29d42e">

### **3) DetailActivtiy**

<img width="200" alt="detail" src="https://github.com/AgileCatch/finder/assets/106515742/8061b768-bbfa-4cc4-8b3e-72847b76264d">

### **4) MyVideoFragment**

<img width="200" alt="myVideo" src="https://github.com/AgileCatch/finder/assets/106515742/bbab577b-f528-444b-8fb2-7769821a301b">

## **Figma를 활용한 전반적인 UI/UX 디자인**

**1. HomeFragment**

- **인기 동영상을 표시하는 인디케이터와 자동 스크롤 기능을 구현**하여 **UX를 향상**
- **Spinner와 RecyclerView를 활용**하여 동영상 목록을 효과적으로 표시하고, 선택된 동영상에 대한 디테일 Activity로 화면을 전환하도록 구현

**2. MyVideoFragment**

- 갤러리에서 사진을 가져오기 위한 **권한 허용 로직**을 도입하여 **UX를 향상**
- **SharedPreferences를 활용**하여 앱 내에 프로필과 닉네임을 저장하고 관리할 수 있도록 구현

**3. SearchFragment**

- **FAB(Button)를 도입**하여 버튼 클릭 시 최상단으로 이동하도록 구현하여 **UX 향상**
- **Glide 라이브러리를 활용**하여 대용량 이미지를 효과적으로 처리하여 **UX 향상**

---

### **MVVM 디자인 패턴을 적용하여 유지보수성 향상**

- **기존 :** 코드의 **유지보수성이 낮고 가독성**이 떨어져 MVVM 디자인 패턴을 도입

- **MVVM 디자인 패턴을 도입**하여 각 Fragment의 비즈니스 로직을 ViewModel로 분리함.
    - 가독성이 향상되고 유지보수성 향상됨

---

### **ViewPager2와 TabLayout을 사용하여 Fragment 분리**

- **기존 :** 단일 화면에서 여러 기능을 수행하던 코드를 **유지보수 및 협업의 편의성을 고려하여 ViewPager2와 TabLayout을 도입함**

- **ViewPager2와 TabLayout을 활용**하여 메인 화면을 3개의 Fragment로 분리
    - 이로써 팀원 간의 협업이 원활해졌고 각각의 Fragment를 독립적으로 개발할 수 있게 됨

## 💡트러블슛팅 및 느낀점

### **마이비디오 페이지 다이얼로그 수정 문제 해결**

- **문제 상황 :** Dialog 클래스로 프로필 사진과 닉네임을 수정하는 부분을 구현 중 **갤러리를 불러오지 못하는 문제가 발생**
- **시도한 방법 :** Dialog 클래스에서는 registerForActivityResult를 사용할 수 없어 intent를 사용하여 값을 전달하고, 프래그먼트에서 registerForActivityResult를 구현하여 동작을 연결해보았지만 매끄러운 작동이 이루어지지 않음
- **해결 방법 :** Dialog 클래스를 **Dialog Fragment로 변경**하여 다른 Fragment에서 구현했던 register를 Dialog Fragment로 이동하고 동작 처리를 하여 문제를 해결했습니다.
- **느낀 점 :** 로직을 작성하기 전에 미리 어떻게 구현할지, 어떤 것을 사용할지를 고려하고 동작에 최적화된 로직을 작성해야 한다는 것을 깨달았습니다. 수정 전에 목표를 명확히 하고 구현 방향을 정하는 것이 중요하다고 느꼈습니다.

---

### **ViewPager / RecyclerView 충돌 문제 해결**

- **문제 상황 :** **ViewPager와 가로 RecyclerView 간 충돌** 문제가 발생
- **시도한 방법 :** NestedScrollView를 활용하여 충돌을 어느 정도 완화하려 했으나, 여전히 문제가 지속됨
- **해결 방법 :** **ViewPager의 Slide 기능을 제거**하여 충돌을 완전히 해결하였습니다.
- **느낀 점 :** 초기 설계 단계에서 ViewPager와 RecyclerView 충돌 문제를 미리 인지하고 다른 기능을 선택했다면 문제가 발생하지 않았을 것이라고 생각합니다. 초기 설계 단계에서 발생 가능한 충돌을 고려하는 것이 중요함을 깨달았습니다.

[💡[Devolg] 뷰페이저 중복문제 해결하기](https://agilecatch.github.io/devlog/fixit/2023-09-27-%EB%B7%B0%ED%8E%98%EC%9D%B4%EC%A0%80%EC%A4%91%EB%B3%B5/)


