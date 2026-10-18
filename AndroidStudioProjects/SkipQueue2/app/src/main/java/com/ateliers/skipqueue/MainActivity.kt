package tn.isetmahdia.skipqueue3

class MainActivity : /*@@vfpyow@@*/AppCompatActivity() {
    var tvTitle: /*@@mgwriw@@*/EditText? = null

    override fun /*@@dbeqjq@@*/onCreate(savedInstanceState: /*@@uohoce@@*/android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        /*~~gfuzcg~~*/this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById</*@@mkwjge@@*/android.view.View?>(R.id.main), /*@@gikygj@@*/androidx.core.view.OnApplyWindowInsetsListener {
        v: /*@@mkwjge@@*/android.view.View?, insets: /*@@eyburl@@*/WindowInsetsCompat? -> val systemBars: /*@@pomuij@@*/androidx.core.graphics.Insets? = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
        })

        val e1: /*@@mjcciu@@*/EditText? = findViewById</*@@mjcciu@@*/EditText?>(R.id.editText1)
        val e2: /*@@mjcciu@@*/EditText? = findViewById</*@@mjcciu@@*/EditText?>(R.id.editText2)
        val e3: /*@@mjcciu@@*/EditText? = findViewById</*@@mjcciu@@*/EditText?>(R.id.editText3)
        val e4: /*@@mjcciu@@*/EditText? = findViewById</*@@mjcciu@@*/EditText?>(R.id.editText4)
        val b: /*@@rnwgez@@*/android.widget.Button? = findViewById</*@@rnwgez@@*/android.widget.Button?>(R.id.button1)
        b.setOnClickListener(/*@@uwsyrf@@*/android.view.View.OnClickListener {
        v: /*@@mkwjge@@*/android.view.View? -> val email: /*@@suxnnz@@*/kotlin.String? = e2.getText().toString()
        val mdp: /*@@suxnnz@@*/kotlin.String? = e3.getText().toString()
        val mdp2: /*@@suxnnz@@*/kotlin.String? = e4.getText().toString()
        if (e1.getText().toString().isEmpty()
        || !email.contains("@") || mdp.length < 8 || (mdp != mdp2)) {
            Toast.makeText(/*~~hfooqq~~*/this@MainActivity , "Error", Toast.LENGTH_SHORT).show()
            e1.setText("")
            e2.setText("")
            e3.setText("")
            e4.setText("")
        } else {
            Toast.makeText(/*~~aexmdb~~*/this@MainActivity , "OK", Toast.LENGTH_SHORT).show()
        }

        })
    }
}