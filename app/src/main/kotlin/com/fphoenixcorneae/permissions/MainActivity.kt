package com.fphoenixcorneae.permissions

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnLocation -> {
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
            }
            R.id.btnPhone -> {
                requestPhonePermission(shouldShowRationale = true) {
                    onGranted {
                        // TODO
                    }
                    onDenied {
                        // ignore
                    }
                    onShowRationale { permissions, positive, negative ->
                        AlertDialog.Builder(this@MainActivity)
                            .setTitle("权限申请")
                            .setMessage("需要申请电话权限")
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
                        openApplicationDetailsSettings()
                    }
                }
            }
            R.id.btnWrite -> {
                requestWritePermission(shouldShowRationale = true) {
                    onGranted {
                        // TODO
                    }
                    onDenied {
                        // ignore
                    }
                    onShowRationale { permissions, positive, negative ->
                        AlertDialog.Builder(this@MainActivity)
                            .setTitle("权限申请")
                            .setMessage("需要申请读写存储权限")
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
                        openApplicationDetailsSettings()
                    }
                }
            }
            R.id.btnSMS -> {
                requestSmsPermission(shouldShowRationale = true) {
                    onGranted {
                        // TODO
                    }
                    onDenied {
                        // ignore
                    }
                    onShowRationale { permissions, positive, negative ->
                        AlertDialog.Builder(this@MainActivity)
                            .setTitle("权限申请")
                            .setMessage("需要申请短信权限")
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
                        openApplicationDetailsSettings()
                    }
                }
            }
            R.id.btnCamera -> {
                requestCameraPermission(shouldShowRationale = true) {
                    onGranted {
                        // TODO
                    }
                    onDenied {
                        // ignore
                    }
                    onShowRationale { permissions, positive, negative ->
                        AlertDialog.Builder(this@MainActivity)
                            .setTitle("权限申请")
                            .setMessage("需要申请相机权限")
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
                        openApplicationDetailsSettings()
                    }
                }
            }
            else -> {}
        }
    }

    /**
     * Open App Detail page
     */
    @SuppressLint("ObsoleteSdkInt")
    fun openApplicationDetailsSettings() {
        val intent = Intent()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            intent.data = Uri.fromParts("package", packageName, null)
        } else {
            val appPkgName =
                when (Build.VERSION.SDK_INT) {
                    Build.VERSION_CODES.FROYO -> "pkg"
                    else -> "com.android.settings.ApplicationPkgName"
                }
            intent.action = Intent.ACTION_VIEW
            intent.setClassName(
                "com.android.settings",
                "com.android.settings.InstalledAppDetails"
            )
            intent.putExtra(appPkgName, packageName)
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        applicationContext.startActivity(intent)
    }
}