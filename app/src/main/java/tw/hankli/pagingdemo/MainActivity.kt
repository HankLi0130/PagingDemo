package tw.hankli.pagingdemo

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val adapter: MainAdapter = MainAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 分隔線
        val itemDecor = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        view_item_list.addItemDecoration(itemDecor)

        view_item_list.setHasFixedSize(true)
        view_item_list.adapter = adapter

        adapter.items = viewModel.getItems()
        adapter.notifyDataSetChanged()
    }
}
