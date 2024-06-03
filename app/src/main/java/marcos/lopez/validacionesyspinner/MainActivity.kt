package marcos.lopez.validacionesyspinner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Mandar a llamar a todos los elementos
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val txtDUI = findViewById<EditText>(R.id.txtDui)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //Agregar un evento al boton
        btnAgregar.setOnClickListener {
            //Validamos que los compos no estén vacios
            if (txtEdad.text.isEmpty()
                || txtNombre.text.isEmpty()
                || txtCorreo.text.isEmpty()
                || txtContrasena.text.isEmpty()
                || txtDUI.text.isEmpty()){
                    Toast.makeText(this,"Llene todos los campos", Toast.LENGTH_SHORT).show()
                //Validamos la edad solo con numeros
            }else if (txtEdad.text.matches("[0-9]+".toRegex())){
                Toast.makeText(this, "Campos Agregados", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Por favor ingrese numero en la edad", Toast.LENGTH_SHORT).show()
            }

            //Validamos Correo electronico
            if(txtCorreo.text.matches("[a-zA-Z0-9._-]+@[a-z]+\\\\-+[a-z]+]".toRegex())){
                Toast.makeText(this, "Correo real", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,"Correo no real", Toast.LENGTH_SHORT).show()
            }
            //Validar la contraseña para que tenga mas de 6 digitos
            if(txtContrasena.text.length < 6 ){
                Toast.makeText(this, "Debe tener mas de 6 digitos", Toast.LENGTH_SHORT).show()
            }

            //Validar el dui
            if(txtDUI.text.matches("[0-9]+-[0-9]".toRegex()) && txtDUI.text.length <= 10 ){
                Toast.makeText(this, "DUI Correcto", Toast.LENGTH_SHORT).show()
                }
            else{

            }

            if(txtNombre.text.matches("[a-zA-Z]".toRegex())){

        }
    }}
}