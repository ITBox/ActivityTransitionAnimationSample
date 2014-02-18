package cc.itbox.activitytransitionanimation;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Spinner sprAnim = (Spinner) findViewById(R.id.sprAnim);
		// 获取相应对象
		String[] ls = getResources().getStringArray(R.array.anim_type);
		List<String> list = new ArrayList<String>();
		// 获取XML中定义的数组
		for (int i = 0; i < ls.length; i++) {
			list.add(ls[i]);
		}
		ArrayAdapter<String> animType = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		animType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sprAnim.setAdapter(animType);
		sprAnim.setSelection(0);
		Button btn1 = (Button) findViewById(R.id.btn1);
		Button btn2 = (Button) findViewById(R.id.btn2);
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
			btn2.setEnabled(true);
		}
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						OtherActivity.class);
				startActivity(intent);
				switch (sprAnim.getSelectedItemPosition()) {
				case 0:
					overridePendingTransition(R.anim.fade, R.anim.hold);
					break;
				case 1:
					overridePendingTransition(R.anim.my_scale_action,
							R.anim.my_alpha_action);
					break;
				case 2:
					overridePendingTransition(R.anim.scale_rotate,
							R.anim.my_alpha_action);
					break;
				case 3:
					overridePendingTransition(R.anim.scale_translate_rotate,
							R.anim.my_alpha_action);
					break;
				case 4:
					overridePendingTransition(R.anim.scale_translate,
							R.anim.my_alpha_action);
					break;
				case 5:
					overridePendingTransition(R.anim.hyperspace_in,
							R.anim.hyperspace_out);
					break;
				case 6:
					overridePendingTransition(R.anim.push_left_in,
							R.anim.push_left_out);
					break;
				case 7:
					overridePendingTransition(R.anim.push_up_in,
							R.anim.push_up_out);
					break;
				case 8:
					overridePendingTransition(R.anim.slide_left,
							R.anim.slide_right);
					break;
				case 9:
					overridePendingTransition(R.anim.wave_scale,
							R.anim.my_alpha_action);
					break;
				case 10:
					overridePendingTransition(R.anim.zoom_enter,
							R.anim.zoom_exit);
					break;
				case 11:
					overridePendingTransition(R.anim.slide_up_in,
							R.anim.slide_down_out);
					break;
				}
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						OtherActivity.class);
				ActivityOptions opts = null;
				switch (sprAnim.getSelectedItemPosition()) {
				case 0:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.fade, R.anim.hold);
					break;
				case 1:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.my_scale_action,
							R.anim.my_alpha_action);
					break;
				case 2:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.scale_rotate,
							R.anim.my_alpha_action);
					break;
				case 3:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.scale_translate_rotate,
							R.anim.my_alpha_action);
					break;
				case 4:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.scale_translate,
							R.anim.my_alpha_action);
					break;
				case 5:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.hyperspace_in,
							R.anim.hyperspace_out);
					break;
				case 6:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.push_left_in,
							R.anim.push_left_out);
					break;
				case 7:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.push_up_in,
							R.anim.push_up_out);
					break;
				case 8:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.slide_left,
							R.anim.slide_right);
					break;
				case 9:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.wave_scale,
							R.anim.my_alpha_action);
					break;
				case 10:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.zoom_enter,
							R.anim.zoom_exit);
					break;
				case 11:
					opts = ActivityOptions.makeCustomAnimation(
							MainActivity.this, R.anim.slide_up_in,
							R.anim.slide_down_out);
					break;
				}
				startActivity(intent, opts.toBundle());
			}

		});

	}
}
