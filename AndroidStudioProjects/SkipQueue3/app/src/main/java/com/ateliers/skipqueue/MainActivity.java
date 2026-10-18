
        package com.ateliers.skipqueue;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 30;
    private static final int MIN_PASSWORD_LENGTH = 8;

    private TextInputLayout tilNom, tilEmail, tilMotDePasse, tilConfirmation;
    private TextInputEditText etNom, etEmail, etMotDePasse, etConfirmation;
    private Button btnInscrire, btnInvite, btnDejaCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tilNom = findViewById(R.id.tilNom);
        tilEmail = findViewById(R.id.tilEmail);
        tilMotDePasse = findViewById(R.id.tilMotDePasse);
        tilConfirmation = findViewById(R.id.tilConfirmation);

        etNom = findViewById(R.id.etNom);
        etEmail = findViewById(R.id.etEmail);
        etMotDePasse = findViewById(R.id.etMotDePasse);
        etConfirmation = findViewById(R.id.etConfirmation);

        btnInscrire = findViewById(R.id.btnInscrire);
        btnInvite = findViewById(R.id.btnInvite);
        btnDejaCompte = findViewById(R.id.btnDejaCompte);

        etNom.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) validerNom();
        });

        etEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) validerEmail();
        });

        etMotDePasse.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) validerMotDePasse();
        });

        etConfirmation.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) validerConfirmation();
        });

        btnInscrire.setOnClickListener(v -> {
            if (validerTout()) {
                Toast.makeText(
                        this,
                        R.string.msg_inscription_ok,
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                Snackbar.make(
                        btnInscrire,
                        R.string.err_form_invalid,
                        Snackbar.LENGTH_LONG
                ).show();
            }
        });

        btnInvite.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        R.string.msg_invite,
                        Toast.LENGTH_SHORT
                ).show()
        );
    }

    private boolean validerNom() {
        String nom = String.valueOf(etNom.getText()).trim();

        if (nom.isEmpty()) {
            tilNom.setError(getString(R.string.err_name_empty));
            return false;
        }

        if (nom.length() < MIN_NAME_LENGTH) {
            tilNom.setError(getString(R.string.err_name_short));
            return false;
        }

        if (nom.length() > MAX_NAME_LENGTH) {
            tilNom.setError(getString(R.string.err_name_long));
            return false;
        }

        tilNom.setError(null);
        return true;
    }

    private boolean validerEmail() {
        String email = String.valueOf(etEmail.getText()).trim();

        if (email.isEmpty()) {
            tilEmail.setError(getString(R.string.err_email_empty));
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError(getString(R.string.err_email_invalid));
            return false;
        }

        tilEmail.setError(null);
        return true;
    }

    private boolean validerMotDePasse() {
        String mdp = String.valueOf(etMotDePasse.getText());

        if (mdp.isEmpty()) {
            tilMotDePasse.setError(getString(R.string.err_password_empty));
            return false;
        }

        if (mdp.length() < MIN_PASSWORD_LENGTH) {
            tilMotDePasse.setError(getString(R.string.err_password_short));
            return false;
        }

        if (!Pattern.compile("[A-Za-z]").matcher(mdp).find()) {
            tilMotDePasse.setError(getString(R.string.err_password_no_letter));
            return false;
        }

        if (!Pattern.compile("\\d").matcher(mdp).find()) {
            tilMotDePasse.setError(getString(R.string.err_password_no_digit));
            return false;
        }

        tilMotDePasse.setError(null);
        return true;
    }

    private boolean validerConfirmation() {
        String confirmation =
                String.valueOf(etConfirmation.getText());

        String mdp = String.valueOf(etMotDePasse.getText());

        if (confirmation.isEmpty()) {
            tilConfirmation.setError(getString(R.string.err_confirm_empty));
            return false;
        }

        if (!confirmation.equals(mdp)) {
            tilConfirmation.setError(getString(R.string.err_confirm_mismatch));
            return false;
        }

        tilConfirmation.setError(null);
        return true;
    }

    private boolean validerTout() {
        boolean nomValide = validerNom();
        boolean emailValide = validerEmail();
        boolean motDePasseValide = validerMotDePasse();
        boolean confirmationValide = validerConfirmation();

        return nomValide
                && emailValide
                && motDePasseValide
                && confirmationValide;
    }
}