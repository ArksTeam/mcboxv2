package x;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.x.R;

/**
 * @Author Cheese
 * @Date 2023/10/01 13:12
 */
public class Main extends Activity {
    private GridLayout grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.getActionBar().hide();
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWindow().setStatusBarColor(0xFF80C269);
		LinearLayout res=findViewById(R.id.bm_res);
		LinearLayout news=findViewById(R.id.bm_news);
		LinearLayout bbs=findViewById(R.id.bm_bbs);
		LinearLayout me=findViewById(R.id.bm_me);
	    grid = findViewById(R.id.grid);
		addItem(R.drawable.home_map_nor, "地图存档");
		addItem(R.drawable.home_js_nor, "Mod");
		addItem(R.drawable.home_texture_nor, "材质光影");
		addItem(R.drawable.home_skin_nor, "皮肤");
		View view=addItem(R.drawable.home_online_nor, "联机大厅");
		addItem(R.drawable.home_seed, "地图种子");
		// View Event
		view.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					gombbs();
				}
		});
		news.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					gombbs();
				}
			});
		bbs.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					gombbs();
				}
			});
		me.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v) {
					gombbs();
				}
			});
    }
	private RelativeLayout addItem(int resId, String text) {
		RelativeLayout vg=(RelativeLayout) LayoutInflater.from(this).inflate(R.layout.grid_item, null);
		grid.addView(vg);
		vg.getLayoutParams().width=getResources().getDisplayMetrics().widthPixels/3;
		vg.getLayoutParams().height=vg.getChildAt(0).getLayoutParams().height;
		LinearLayout lt=(LinearLayout)vg.getChildAt(0);
		((ImageView)lt.getChildAt(0)).setImageResource(resId);
		((TextView)lt.getChildAt(1)).setText(text);
		return vg;
	}
	private void gombbs(){
		Intent intent = new Intent(Main.this, Browser.class);
		intent.putExtra("url", "http://minecraftbox.link/flink0025");
		startActivity(intent);
	}
}
