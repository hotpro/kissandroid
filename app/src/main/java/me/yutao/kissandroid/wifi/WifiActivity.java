package me.yutao.kissandroid.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import me.yutao.kissandroid.BaseActivity;
import me.yutao.kissandroid.R;

public class WifiActivity extends BaseActivity implements OnClickListener {

	private Button btnSwitchWifi;
	private WifiManager wifiManager;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_wifi);
		btnSwitchWifi = (Button) findViewById(R.id.btn_switch_wifi);
		btnSwitchWifi.setOnClickListener(this);
		wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
		btnSwitchWifi.setText(wifiManager.isWifiEnabled() ? "已经开启" : "已经关闭");
	}

	@Override
	public void onClick(View view) {
		if (wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(false);
			btnSwitchWifi.setText("wifi enabled");
		} else {
			wifiManager.setWifiEnabled(true);
			btnSwitchWifi.setText("wifi disabled");
		}
	}

}
