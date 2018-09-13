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
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import android.util.Log
import android.util.SparseArray
import com.google.firebase.firestore.FirebaseFirestore
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentReference
import com.google.android.gms.tasks.OnSuccessListener
import kotlinx.android.synthetic.main.fragment_auth.*
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.withContext
import mobile.egn.com.mobile.test
import org.jetbrains.anko.UI
import kotlin.math.abs


class AuthFragment : BaseFragment() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        solution()
    }

    fun solution() {
//        val a = Int[{ 1, 3, 6, 4, 1, 2 }]
        val a: IntArray = intArrayOf(1, 3, 6, 4, 1, 2 )
//        val a = arrayListOf<Int>(-10, -3, -6, -4, -7, -2,-1)
//        var value = 1
//        while (!inArray(value, a)) {
//            value++
//        }
//
//
//        Log.i("hanhmh1203", "${value}")
        val test = test()
        test.solution(a)
    }

    fun inArray(value: Int, array: List<Int>): Boolean {
        if (value in array) {
            return false
        }
        return true
    }

    fun examCoru(){
        launch {
            async {

            }.await()
            withContext(UI){

            }
            withContext(UI){

            }

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            fireStore()
        }
        button2.setOnClickListener {
            readData()
        }
    }

    override fun onStart() {
        super.onStart()
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            updateUI(currentUser)
//        }
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

    val db = FirebaseFirestore.getInstance()
    private fun fireStore() {
        // Create a new user with a first and last name
        val user = HashMap<String, Any>()
//        user.put("first", "Ada")
//        user.put("last", "Lovelace")
//        user.put("born", 1815)
//
//// Add a new document with a generated ID
//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener { documentReference ->
//                    Log.i("updatedb", "DocumentSnapshot added with ID: " + documentReference.id)
//                }
//                .addOnFailureListener { e ->
//                    Log.e("updatedb", "Error adding document", e)
//                }


        // Create a new user with a first, middle, and last name
        user.put("first", "Alan")
        user.put("middle", "Mathison")
        user.put("last", "Turing")
        user.put("born", 1912)

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener { Log.i("updatedb", "DocumentSnapshot added with ID: " + it.id) }
                .addOnFailureListener {
                    Log.e("updatedb", "Error adding document", it)
                }
    }

    fun readData() {
        val TAG = "readdata"
        db.collection("users")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result) {
                            Log.i(TAG, document.id + " => " + document.data)
                        }
                    } else {
                        Log.e(TAG, "Error getting documents.", task.exception)
                    }
                }
    }


    override fun layoutId() = R.layout.fragment_auth

}