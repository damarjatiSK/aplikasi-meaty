package com.damar.meaty.customview

import android.widget.TextView
import com.damar.meaty.databinding.ActivityLoginBinding
import com.damar.meaty.databinding.ActivityRegisterBinding

class FormValidator {
    companion object {
        fun isValidLogin(binding: ActivityLoginBinding): Boolean {
            var isValid = true

            if (binding.edLoginEmail.text.toString().isEmpty()) {
                binding.edLoginEmail.error = "Email tidak boleh kosong"
                isValid = false
            }

            if (binding.edLoginPassword.text.toString().isEmpty()) {
                binding.edLoginPassword.error = "Password tidak boleh kosong"
                isValid = false
            }
            if (binding.edLoginPassword.text.toString().length < 8) {
                binding.edLoginPassword.error = "Karakter password harus 8 atau lebih"
                isValid = false
            }

            return isValid
        }

        fun isValidRegister(binding: ActivityRegisterBinding): Boolean {
            var isValid = true
            if (binding.edRegisterName.text.toString().isEmpty()) {
                binding.edRegisterName.error = "Nama tidak boleh kosong"
                isValid = false
            }
            if (binding.edRegisterEmail.text.toString().isEmpty()) {
                binding.edRegisterEmail.error = "Email tidak boleh kosong"
                isValid = false
            }
            if (binding.spinnerGender.selectedItem.toString().isEmpty()) {
                val errorText = "Jenis kelamin tidak boleh kosong"
                (binding.spinnerGender.selectedView as TextView).error = errorText
                isValid = false
            }
            if (binding.edRegisterPassword.text.toString().isEmpty()) {
                binding.edRegisterPassword.error = "Password tidak boleh kosong"
                isValid = false
            }
            if (binding.edRegisterDomisili.text.toString().isEmpty()) {
                binding.edRegisterDomisili.error = "Domisili tidak boleh kosong"
                isValid = false
            }
            val ageText = binding.edRegisterAge.text.toString()
            if (ageText.isEmpty()) {
                binding.edRegisterAge.error = "Usia tidak boleh kosong"
                isValid = false
            } else {
                val age = ageText.toIntOrNull()
                if (age == null || age < 0) {
                    binding.edRegisterAge.error = "Usia harus diisi dengan angka yang valid"
                    isValid = false
                }
            }
            if (binding.edRegisterWork.text.toString().isEmpty()) {
                binding.edRegisterWork.error = "Pekerjaan tidak boleh kosong"
                isValid = false
            }
            if (binding.edRegisterPassword.text.toString().length < 8) {
                binding.edRegisterPassword.error = "Karakter password harus 8 atau lebih"
                isValid = false
            }
            return isValid
        }
    }
}
