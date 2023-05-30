package com.damar.meaty.customview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import com.damar.meaty.databinding.ActivityLoginBinding
import com.damar.meaty.databinding.ActivityRegisterBinding

class AnimationUtil {
    companion object {
        fun playLoginAnimation(binding: ActivityLoginBinding) {
            val emailAnimator = ObjectAnimator.ofFloat(binding.fieldEmail, View.ALPHA, 1f).setDuration(500)
            val passwordAnimator = ObjectAnimator.ofFloat(binding.fieldPassword, View.ALPHA, 1f).setDuration(480)
            val loginButtonAnimator = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(460)
            val textView1Animator = ObjectAnimator.ofFloat(binding.textView2, View.ALPHA, 1f).setDuration(440)
            val textView2Animator = ObjectAnimator.ofFloat(binding.txtSignUp, View.ALPHA, 1f).setDuration(420)

            val togetherAnimator = AnimatorSet().apply {
                playTogether(textView1Animator, textView2Animator)
            }
            AnimatorSet().apply {
                playSequentially(emailAnimator, passwordAnimator, loginButtonAnimator, togetherAnimator)
                start()
            }
        }

        fun playRegisAnimation(binding: ActivityRegisterBinding) {
            val nameAnimator = ObjectAnimator.ofFloat(binding.fieldName, View.ALPHA, 1f).setDuration(500)
            val emailAnimator = ObjectAnimator.ofFloat(binding.fieldEmail, View.ALPHA, 1f).setDuration(460)
            val genderAnimator = ObjectAnimator.ofFloat(binding.fieldGender, View.ALPHA, 1f).setDuration(420)
            val domisiliAnimator = ObjectAnimator.ofFloat(binding.fieldDomisili, View.ALPHA, 1f).setDuration(380)
            val ageAnimator = ObjectAnimator.ofFloat(binding.fieldAge, View.ALPHA, 1f).setDuration(340)
            val workAnimator = ObjectAnimator.ofFloat(binding.fieldWork, View.ALPHA, 1f).setDuration(300)
            val passwordAnimator = ObjectAnimator.ofFloat(binding.fieldPassword, View.ALPHA, 1f).setDuration(260)
            val registerButtonAnimator = ObjectAnimator.ofFloat(binding.btnRegister, View.ALPHA, 1f).setDuration(220)
            val textView1Animator = ObjectAnimator.ofFloat(binding.textView2, View.ALPHA, 1f).setDuration(180)
            val textView2Animator = ObjectAnimator.ofFloat(binding.txtLogin, View.ALPHA, 1f).setDuration(140)

            val togetherAnimator = AnimatorSet().apply {
                playTogether(textView1Animator, textView2Animator)
            }
            AnimatorSet().apply {
                playSequentially(nameAnimator, emailAnimator, genderAnimator, domisiliAnimator, ageAnimator, workAnimator, passwordAnimator, registerButtonAnimator, togetherAnimator)
                start()
            }
        }
    }
}