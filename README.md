![HEADER](https://capsule-render.vercel.app/api?type=rect&color=gradient&height=100&section=header&text=side-project-module&fontSize=30&fontAlign=50&fontAlignY=50)

## About💡
> 프로젝트에서 사용되는 모듈을 관리하는 Repository

## 🔖 Project  Requirement 

### ⚠️  Dependency
```kotlin 
  compileSdk 32
  minSdk 24
  targetSdk 32
```
### arr 파일 명명법 
```kotlin 
  output.outputFileName = "${archivesBaseName}-${defaultConfig.versionName}.aar"
```
> ex : base-1.0.0.aar (모듈명)-versionName

### Project Sturct
```bash
.
├──-                              # app-android-module
│   ├── Base
│       ├── View                    # Base View -> Activity,Fragment....
│       └── ViewModel               # Base ViewModel
├──-
│   ├── Core
│       ├── Mvi                    # mvi architecture Interface 

```

## Developers
송현수 sj960126@naver.co.kr<br>
