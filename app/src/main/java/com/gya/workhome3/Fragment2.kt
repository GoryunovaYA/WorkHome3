package com.gya.workhome3

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.fragment.app.Fragment
import com.gya.workhome3.databinding.ActivityMainBinding.inflate
import com.gya.workhome3.databinding.Fragment1Binding
import com.gya.workhome3.databinding.Fragment2Binding
import com.gya.workhome3.databinding.FragmentMainBinding

class Fragment2 : Fragment() {

    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    private lateinit var cursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Fragment2Binding.inflate(layoutInflater)
        binding.root
        val db = DataBase.getDB(requireContext())

        Thread {
            cursor = db.getDao().getAllClients()
            cursor.moveToFirst()
            binding.TextViewFamiliya2.text = cursor.getString(1)
            binding.TextViewame2.text = cursor.getString(2)
            binding.TextViewSecondName2.text = cursor.getString(3)
            binding.TextViewYears2.text = cursor.getString(4)
            binding.TextViewHome2.text = cursor.getString(5)
        }.start()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn: ImageButton = binding.imageButton

        btn.setOnClickListener {
            onClickbut()
            cursor.moveToNext()
        }
    }

    private fun onClickbut() {
        Thread {
            if (!cursor.isAfterLast) {
                binding.TextViewFamiliya2.text = cursor.getString(1)
                binding.TextViewame2.text = cursor.getString(2)
                binding.TextViewSecondName2.text = cursor.getString(3)
                binding.TextViewYears2.text = cursor.getString(4)
                binding.TextViewHome2.text = cursor.getString(5)
            }
        }.start()
    }

}


