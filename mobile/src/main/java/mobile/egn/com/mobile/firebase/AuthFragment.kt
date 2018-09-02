package mobile.egn.com.mobile.firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.experimental.launch
import mobile.egn.com.androidxcore.extension.logI
import mobile.egn.com.androidxcore.view.base.BaseFragment
import mobile.egn.com.mobile.R
import mobile.egn.com.mobile.app
import android.widget.Toast
import jdk.nashorn.internal.runtime.ECMAException.getException
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import android.util.Log


class AuthFragment : BaseFragment() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            updateUI(currentUser)
        }
    }

    fun updateUI(user: FirebaseUser) {
        "updateUi".logI("${user.displayName!!}")
    }

    companion object {
        @JvmStatic
        fun newsIntance() =
                AuthFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

    fun test() {
    }

    fun signin() {
//        auth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        "signin".logI("signInWithEmail:success")
//                        val user = auth.getCurrentUser()
//                        if (user != null) {
//                            updateUI(user)
//                        }
//                    } else {
//                        // If sign in fails, display a message to the user.
////                        Toast.makeText(this@EmailPasswordActivity, "Authentication failed.",
////                                Toast.LENGTH_SHORT).show()
////                        updateUI(null)
//                    }
//
//                })
    }

    override fun layoutId() = R.layout.fragment_auth

}