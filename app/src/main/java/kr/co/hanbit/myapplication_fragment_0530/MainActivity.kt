package kr.co.hanbit.myapplication_fragment_0530

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.myapplication_fragment_0530.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    lateinit var listFragment:ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment() //setFragment() 호출
        binding.btnSend.setOnClickListener{
            listFragment.setValue("전달할 값")
        }
    }

    fun setFragment(){
        listFragment = ListFragment()

        var bundle = Bundle()
        bundle.putString("key1","List Fragment")
        bundle.putInt("key2",20220530)
        listFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }
    fun goDetail(){
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }
    fun goBack(){
        onBackPressed()
    }
}