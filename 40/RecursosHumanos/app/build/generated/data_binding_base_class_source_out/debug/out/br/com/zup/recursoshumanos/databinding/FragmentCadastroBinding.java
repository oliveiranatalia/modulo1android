// Generated by view binder compiler. Do not edit!
package br.com.zup.recursoshumanos.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import br.com.zup.recursoshumanos.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCadastroBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button botao;

  @NonNull
  public final EditText etHoras;

  @NonNull
  public final EditText etNome;

  @NonNull
  public final EditText etValor;

  @NonNull
  public final TextView tvTituloCadastro;

  private FragmentCadastroBinding(@NonNull ConstraintLayout rootView, @NonNull Button botao,
      @NonNull EditText etHoras, @NonNull EditText etNome, @NonNull EditText etValor,
      @NonNull TextView tvTituloCadastro) {
    this.rootView = rootView;
    this.botao = botao;
    this.etHoras = etHoras;
    this.etNome = etNome;
    this.etValor = etValor;
    this.tvTituloCadastro = tvTituloCadastro;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCadastroBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCadastroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_cadastro, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCadastroBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.botao;
      Button botao = ViewBindings.findChildViewById(rootView, id);
      if (botao == null) {
        break missingId;
      }

      id = R.id.etHoras;
      EditText etHoras = ViewBindings.findChildViewById(rootView, id);
      if (etHoras == null) {
        break missingId;
      }

      id = R.id.etNome;
      EditText etNome = ViewBindings.findChildViewById(rootView, id);
      if (etNome == null) {
        break missingId;
      }

      id = R.id.etValor;
      EditText etValor = ViewBindings.findChildViewById(rootView, id);
      if (etValor == null) {
        break missingId;
      }

      id = R.id.tvTituloCadastro;
      TextView tvTituloCadastro = ViewBindings.findChildViewById(rootView, id);
      if (tvTituloCadastro == null) {
        break missingId;
      }

      return new FragmentCadastroBinding((ConstraintLayout) rootView, botao, etHoras, etNome,
          etValor, tvTituloCadastro);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}