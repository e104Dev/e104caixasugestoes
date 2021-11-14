# Caixa Sugestões Etec Artur Nogueira

Este é o passo-a-passo do desenvolvimento do `Aplicativo Android de Caixa de Sugestões`, complementar ao `WebSite Caixa de Sugestões` desenvolvido em PHP.

## Step by Step

### GUI - Graphic User Interface

#### MainActivity - Layout
A interface gráfica já foi criada anteriormente em sala de aula, então segue abaixo o código da interface gráfica em xml para conferência.

##### Recursos necessários

Abaixo segue o link das imagens e vetores necessários para a criação da interface.

[Recursos](https://github.com/e104SysDev/e104caixasugestoes/tree/main/app/src/main/res/drawable)

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/background_laranja_200"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="180dp"
        android:layout_marginTop="16dp"
        android:adjustViewBounds="true"
        android:cropToPadding="true"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/ic_suggestion" />

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:background="@drawable/fundo_main_card"
        android:elevation="8dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView">

        <TextView
            android:id="@+id/textView4"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="8dp"
            android:layout_marginTop="16dp"
            android:layout_marginEnd="16dp"
            android:text="Caixa Sugestões"
            android:textAlignment="center"
            android:textAppearance="@style/TextAppearance.AppCompat.Display1"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toEndOf="@+id/imageView3"
            app:layout_constraintTop_toTopOf="parent" />

        <ImageView
            android:id="@+id/imageView3"
            android:layout_width="wrap_content"
            android:layout_height="48dp"
            android:layout_marginStart="16dp"
            android:adjustViewBounds="true"
            android:cropToPadding="true"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/textView4"
            app:srcCompat="@drawable/ic_trajano" />

        <EditText
            android:id="@+id/editTextSugestao"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="8dp"
            android:layout_marginEnd="16dp"
            android:ems="10"
            android:hint="Nos ajude com sua opinião"
            android:inputType="textPersonName"
            android:minHeight="48dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/imageView3" />

        <Spinner
            android:id="@+id/spinnerCurso"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="8dp"
            android:layout_marginEnd="8dp"
            android:entries="@array/cursos"
            android:minHeight="48dp"
            app:layout_constraintEnd_toStartOf="@+id/spinnerTipo"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/editTextSugestao" />

        <Spinner
            android:id="@+id/spinnerTipo"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="8dp"
            android:layout_marginEnd="16dp"
            android:entries="@array/tipos"
            android:minHeight="48dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toEndOf="@+id/spinnerCurso"
            app:layout_constraintTop_toTopOf="@+id/spinnerCurso" />

        <EditText
            android:id="@+id/editTextNome"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="8dp"
            android:layout_marginEnd="16dp"
            android:ems="10"
            android:hint="Seu nome, mas não é obrigatório"
            android:inputType="textPersonName"
            android:minHeight="48dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/spinnerCurso" />

        <Button
            android:id="@+id/buttonEnviar"
            android:layout_width="0dp"
            android:layout_height="60dp"
            android:layout_marginStart="16dp"
            android:layout_marginEnd="16dp"
            android:layout_marginBottom="8dp"
            android:onClick="abrirSugestoes"
            android:text="enviar"
            app:cornerRadius="30dp"
            app:layout_constraintBottom_toTopOf="@+id/buttonAbrirSugestoes"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent" />

        <Button
            android:id="@+id/buttonAbrirSugestoes"
            style="@style/Widget.MaterialComponents.Button.OutlinedButton"
            android:layout_width="0dp"
            android:layout_height="60dp"
            android:layout_marginStart="16dp"
            android:layout_marginEnd="16dp"
            android:onClick="visualizarSugestoes"
            android:text="visualizar sugestões"
            app:cornerRadius="30dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent" />
    </androidx.constraintlayout.widget.ConstraintLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### Strings.xml

```xml
<resources>
    <string name="app_name">Caixa de Sugestoes</string>
    <string name="titulo_alerta_carregamento">Carregando</string>
    <string name="mensagem_carregamento">Carregando sugestões, por favor aguarde...</string>
    <string-array name="cursos">
        <item>Sistemas</item>
        <item>Administracao</item>
        <item>Logistica</item>
    </string-array>
    <string-array name="tipos">
        <item>Sugestao</item>
        <item>Elogio</item>
        <item>Comentario</item>
        <item>Reclamacao</item>
    </string-array>

    <string-array name="sabor_esfiha">
        <item>"Carne Seca Foverver</item>
        <item>Baianinha Super Apimentada</item>
    </string-array>
</resources>
``` 

#### Tema

Para este aplicativo foi configurado as cores para o `tema claro` e o `tema escuro`; então a aparencia do aplicativo será alterada conform as configurações do Sistema Operacional.
Abaixo, seguem as cores utilizadas nos 2 temas, fique a vontade par alterar as cores em seu projeto;

##### Cores

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!-- Tema claro -->
    <color name="purple_200">#F48FB1</color>
    <color name="purple_500">#E91E63</color>
    <color name="purple_700">#C2185B</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>

    <!-- Tema escuro -->
    <color name="laranja_200">#FFAB91</color>
    <color name="background_laranja_200">#38FFAB91</color>
    <color name="laranja_500">#FF5722</color>
    <color name="laranja_700">#E64A19</color>
    <color name="azul_200">#81D4FA</color>
    <color name="azul_700">#0288D1</color>
</resources>
``` 

##### Tema Claro - theme

```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.E104CaixaSugestoes" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/laranja_500</item>
        <item name="colorPrimaryVariant">@color/laranja_700</item>
        <item name="colorOnPrimary">@color/white</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/azul_200</item>
        <item name="colorSecondaryVariant">@color/azul_700</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
``` 

##### Tema Escuro - theme/night

```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.E104CaixaSugestoes" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/laranja_200</item>
        <item name="colorPrimaryVariant">#171717</item>
        <item name="colorOnPrimary">@color/black</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/laranja_200</item>
        <item name="colorSecondaryVariant">@color/laranja_200</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
``` 

#### RecyclerView - Item

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
        app:cardElevation="4dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:padding="16dp">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal">

                <TextView
                    android:id="@+id/textViewTipo"
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:layout_weight="3"
                    android:gravity="center_vertical"
                    android:text="Sugestão"
                    android:textAppearance="@style/TextAppearance.AppCompat.Display1"
                    android:textSize="34sp" />

                <ImageView
                    android:id="@+id/imageViewTipo"
                    android:layout_width="48dp"
                    android:layout_height="48dp"
                    android:layout_gravity="end"
                    android:layout_weight="1"
                    android:adjustViewBounds="false"
                    tools:srcCompat="@drawable/idea" />
            </LinearLayout>

            <TextView
                android:id="@+id/textViewConteudo"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="8dp"
                android:layout_marginBottom="8dp"
                android:layout_weight="1"
                android:text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sapien elit, vulputate eget arcu et, placerat viverra enim. Nulla pretium ex luctus, cursus ligula in, iaculis dui." />

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:weightSum="3">

                <TextView
                    android:id="@+id/textViewCurso"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:padding="4dp"
                    android:text="Dev Sys"
                    android:textSize="16sp"
                    android:textStyle="bold" />

                <TextView
                    android:id="@+id/textViewNome"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:padding="4dp"
                    android:text="João Pedro"
                    android:textAlignment="center"
                    android:textColor="@color/purple_700" />

                <TextView
                    android:id="@+id/textViewData"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:padding="4dp"
                    android:text="2021-10-22"
                    android:textAlignment="textEnd"
                    android:textColor="@android:color/darker_gray" />
            </LinearLayout>

        </LinearLayout>
    </androidx.cardview.widget.CardView>
</androidx.constraintlayout.widget.ConstraintLayout>
``` 

#### SugestaoListActivity - Layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SugestaoListActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerViewSugestoes"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```


