package com.gya.workhome3

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gya.workhome3.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    lateinit var binding: Fragment1Binding
    var familiya = ""
    var name = ""
    var secondName = ""
    var years = 0
    var home = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DataBase.getDB(requireContext())

        val btn : Button = binding.button
        btn.setOnClickListener {
            familiya = binding.editFamiliya.text.toString()
            name = binding.editName.text.toString()
            secondName = binding.editSecondName.text.toString()
            years = binding.editYears.text.toString().toInt()
            home = binding.editHome.text.toString()

            val client = Clients(null, familiya, name, secondName, years, home)
            Thread {
                db.getDao().insertClients(client)
            }.start()
            Toast.makeText(context, "Клиент создан!!!", Toast.LENGTH_LONG).show()
            binding.editFamiliya.setText("")
            binding.editName.setText("")
            binding.editSecondName.setText("")
            binding.editYears.setText("0")
            binding.editHome.setText("")
        }
    }
}