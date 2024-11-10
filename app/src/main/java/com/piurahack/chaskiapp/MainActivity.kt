package com.piurahack.chaskiapp


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.piurahack.chaskiapp.databinding.ActivityMainBinding
import com.piurahack.chaskiapp.Fragments.Map
import com.piurahack.chaskiapp.Fragments.Community
import com.piurahack.chaskiapp.Fragments.Newspaper
import com.piurahack.chaskiapp.Fragments.Profile

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.getRoot())
        replaceFragment(Map())
        binding!!.bottomNavigationView.setSelectedItemId(R.id.map)

        binding!!.bottomNavigationView.setBackground(null)
        binding!!.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.community -> replaceFragment(Community())
                R.id.newspapper -> replaceFragment(Newspaper())
                R.id.map -> replaceFragment(Map())
                R.id.profile -> replaceFragment(Profile())
            }
            true
        }

        binding!!.fab.setOnClickListener(View.OnClickListener { showBottomDialog() })
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    private fun showBottomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_layout)

        val videoLayout = dialog.findViewById<LinearLayout>(R.id.layoutVideo)
        val shortsLayout = dialog.findViewById<LinearLayout>(R.id.layoutShorts)
        val liveLayout = dialog.findViewById<LinearLayout>(R.id.layoutLive)
        val cancelButton = dialog.findViewById<ImageView>(R.id.cancelButton)

        videoLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(
                this@MainActivity,
                "Upload a Video is clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        shortsLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(
                this@MainActivity,
                "Create a short is Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        liveLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(
                this@MainActivity,
                "Go live is Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        cancelButton.setOnClickListener { dialog.dismiss() }

        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }
}