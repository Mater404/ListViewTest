package activitytest.example.com.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();   //初始化数据
          // 传递数据
          FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
          ListView listView = (ListView) findViewById(R.id.list_view);
        //调用控件显示
        listView.setAdapter(adapter);
          //响应单击事件
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Fruit fruit = fruitList.get(position);
                  Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
              }
          });
    }
    private void initFruits(){
        Fruit a1 = new Fruit("Apple1",R.color.colorAccent);
       // Fruit a1 = new Fruit("Apple",R.drawable.a1);      可实现图片的显示
        fruitList.add(a1);
        Fruit a2 = new Fruit("Apple2",R.color.colorPrimaryDark);
        fruitList.add(a2);
        Fruit a3 = new Fruit("Apple3",R.color.colorPrimary);
        fruitList.add(a3);

    }
}
