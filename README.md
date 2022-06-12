# CoroutinesPermissions

Android library for request dynamic permissions using coroutines' flow.

[![](https://jitpack.io/v/FPhoenixCorneaE/CoroutinesPermissions.svg)](https://jitpack.io/#FPhoenixCorneaE/CoroutinesPermissions)

## How to include it in your project:

**Step 1.** Add the JitPack repository to your build file

```kotlin
allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

**Step 2.** Add the dependency

```kotlin
dependencies {
    implementation("com.github.FPhoenixCorneaE:CoroutinesPermissions:$latest")
}
```

## How to Use:

```kotlin
requestLocationPermission(shouldShowRationale = true) {
    onGranted {
        // TODO
    }
    onDenied {
        // ignore
    }
    onShowRationale { permissions, positive, negative ->
        // 弹窗解释为什么需要该权限
        AlertDialog.Builder(this@MainActivity)
            .setTitle("权限申请")
            .setMessage("需要申请定位权限")
            .setCancelable(false)
            .setNegativeButton("取消") { dialog, which ->
                negative.invoke()
                dialog.dismiss()
            }
            .setPositiveButton("确定") { dialog, which ->
                positive.invoke()
                dialog.dismiss()
            }
            .show()
    }
    onNeverAsk {
        // 拒绝并不再询问
        openApplicationDetailsSettings()
    }
}
```
