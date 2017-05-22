package com.jikexuyuan.permissionutil;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jikexuyuan.permissionutil.util.PermissionUtil;
public class MainActivity extends AppCompatActivity implements PermissionUtil.PermissionCallBack {
    private static final String TAG = "MainActivity";
    protected PermissionUtil mPermissionUtil;
    private static final int PERMISSION_CODE = 999;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: "  );
        mPermissionUtil = PermissionUtil.getInstance();
        mPermissionUtil.requestPermissions(this, PERMISSION_CODE, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        mPermissionUtil.requestResult(this, permissions, grantResults, this);
    }

    @Override
    public void onPermissionSuccess() {
//        initOperate();
    }

    @Override
    public void onPermissionReject(String strMessage) {
//        DialogShowUtils.showPermissionAlertDialog(this, strMessage, mCancelListener, mOkListener);
    }

//    private DialogShowUtils.PermissionDialogCancelListener mCancelListener = new DialogShowUtils.PermissionDialogCancelListener() {
//
//        @Override
//        public void onCancelPressed() {
//            finishAllActivity();
//        }
//    };
//    private DialogShowUtils.PermissionDialogOKListener mOkListener = new DialogShowUtils.PermissionDialogOKListener() {
//        @Override
//        public void onOKPressed() {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (!Settings.System.canWrite(MainActivity.this)) {
//                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                    intent.setData(Uri.parse("package:" + getPackageName()));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                }
//            }
//        }
//    };
    @Override
    public void onPermissionFail() {
        mPermissionUtil.requestPermissions(this, PERMISSION_CODE,this);
    }
}
