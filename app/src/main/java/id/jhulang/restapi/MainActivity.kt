package id.jhulang.restapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val mAPIClient by lazy {
        APIClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPhotos.layoutManager = LinearLayoutManager(this)

        mAPIClient.getPhotos()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it ->
                Log.d("size", it.size.toString())
                setDataInRecyclerView(it);
            }, { it ->
                Log.d("error", "errors")
            })
    }
    private fun setDataInRecyclerView(it: ArrayList<Model.photo>?) {
        rvPhotos.adapter = PhotoAdapter(it!!,this)

    }

}

