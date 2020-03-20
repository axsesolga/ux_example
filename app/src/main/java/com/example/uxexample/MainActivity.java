package com.example.uxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button S_button;
    Button D_button;
    Button F_button;
    Button G_button;
    Button H_button;
    Button J_button;
    Button K_button;
    Button L_button;
    Button Next_button;
    Button Space_button;
    TextView textView;
    ListView listView;
    TextView cur_elem;

    List<String> words_3 = new ArrayList<>();

    static HashMap<Character, List<Character>> dict = new HashMap<Character, List<Character>>();
    static
    {
         dict.put('S', Arrays.asList('ы', 'х', 'в', 'н', 'г'));
         dict.put('D', Arrays.asList('ь', 'я', 'л', 'ц', 'е'));
         dict.put('F', Arrays.asList('к', 'с', 'з'));
         dict.put('G', Arrays.asList('ё', 'э', 'р', 'ж', 'п'));
         dict.put('H', Arrays.asList('а', 'й', 'м'));
         dict.put('J', Arrays.asList('ю', 'щ', 'о', 'б'));
         dict.put('K', Arrays.asList('и', 'ш', 'д', 'ъ'));
         dict.put('L', Arrays.asList('у', 'ф', 'т', 'ч'));
    }

    public String get_random_word(String word)
    {
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++)
        {
            List<Character> letter_arr = dict.get(word.charAt(i));
            sb.append(letter_arr.get(rd.nextInt(letter_arr.size())));
        }
        return sb.toString();
    }
    int cur_index = 0;
    public void update_list()
    {
        String[] words = (textView.getText()).toString().split(" ");
        String last_word = words[words.length - 1];

        words_3 = Arrays.asList(get_random_word(last_word), get_random_word(last_word), get_random_word(last_word));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, words_3);
        listView.setAdapter(arrayAdapter);
        cur_elem.setText(words_3.get(cur_index));
    }
    public void set_listeners()
    {
        S_button = (Button)findViewById(R.id.s_button);
        D_button = (Button)findViewById(R.id.d_button);
        F_button = (Button)findViewById(R.id.f_button);
        G_button = (Button)findViewById(R.id.g_button);
        H_button = (Button)findViewById(R.id.h_button);
        J_button = (Button)findViewById(R.id.j_button);
        K_button = (Button)findViewById(R.id.k_button);
        L_button = (Button)findViewById(R.id.l_button);
        Next_button = (Button)findViewById(R.id.next_button);
        Space_button = (Button)findViewById(R.id.space_button);
        textView = (TextView)findViewById(R.id.textView2);
        listView = (ListView)findViewById(R.id.listView);
        cur_elem = (TextView)findViewById(R.id.cur_elem);



        // создаем обработчик нажатия
        View.OnClickListener S_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("S");
                update_list();
            }
        };
        S_button.setOnClickListener(S_listener);

        View.OnClickListener D_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("D");
                update_list();
            }
        };
        D_button.setOnClickListener(D_listener);

        View.OnClickListener F_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("F");
                update_list();
            }
        };
        F_button.setOnClickListener(F_listener);

        View.OnClickListener G_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("G");
                update_list();
            }
        };
        G_button.setOnClickListener(G_listener);

        View.OnClickListener H_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("H");
                update_list();
            }
        };
        H_button.setOnClickListener(H_listener);

        View.OnClickListener J_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("J");
                update_list();
            }
        };
        J_button.setOnClickListener(J_listener);

        View.OnClickListener K_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("K");
                update_list();
            }
        };
        K_button.setOnClickListener(K_listener);

        View.OnClickListener L_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append("L");
                update_list();
            }
        };
        L_button.setOnClickListener(L_listener);

        View.OnClickListener NEXT_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cur_elem.setText(words_3.get(++cur_index % 3));
            }
        };
        Next_button.setOnClickListener(NEXT_listener);

        View.OnClickListener SPACE_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(" ");

            }
        };
        Space_button.setOnClickListener(SPACE_listener);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        words_3.add(" ");
        words_3.add(" ");
        words_3.add(" ");
        set_listeners();
    }

}
