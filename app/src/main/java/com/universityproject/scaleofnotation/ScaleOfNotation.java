package com.universityproject.scaleofnotation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;

public class ScaleOfNotation extends Activity implements OnClickListener {

    Button popupmenu; //Кнопка вызова выпадающего меню
    Button calc; //Кнопка для перевода из ситемы Х в систему У
    Button exit; //Кнопка выхода из приложения
    TextView edAnswer; //Поле вывода ответа
    EditText number; //Поле ввода числа
    AlertDialog.Builder exitDialog; //Диологовое окно выхода из приложения
    Context context; //Контекст приложения

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        popupmenu = (Button) findViewById(R.id.btn_menu);
        popupmenu.setOnClickListener(this);

        calc = (Button) findViewById(R.id.calc);
        calc.setOnClickListener(this);

        exit = (Button) findViewById(R.id.btnExit);
        exit.setOnClickListener(this);

        context = ScaleOfNotation.this;
        String message = "Вы уверены, что хотите выйти?";
        String btnYes = "Да";
        String btnNo = "Нет";

        exitDialog = new AlertDialog.Builder(context);
        exitDialog.setMessage(message);

        exitDialog.setNegativeButton(btnYes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        exitDialog.setPositiveButton(btnNo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }

//Обработчик кликов по кнопкам

    public void onClick (View v) {
        String numb;
        String answ;
        String sResult ="";
        int intNumb;
        int temp = 0;
        int step = 0;
        int result = 0;
        int tempRes = 0;

        StringBuilder answer = new StringBuilder();
        switch (v.getId()){
//Вызов выпадающего меню
            case R.id.btn_menu:
                showPopupMenu(v);
                break;
//Логика перевода из ситемы Х в систему У
            case R.id.calc:
                try {
                    if (popupmenu.getText() == "Из 2 в 8") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        answ = Integer.toOctalString(Integer.parseInt(numb, 2));
                        edAnswer.setText(answ);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В двоичной системе счисления используются цифры от 0 до 1",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                if (popupmenu.getText() == "Из 2 в 10") {
                    edAnswer = (TextView) findViewById(R.id.edAnswer);
                    number = (EditText) findViewById(R.id.edNumber);
                    numb = number.getText().toString();
                    intNumb = Integer.parseInt(numb);
                    do {
                        temp = intNumb % 10;
                        if ((temp < -1) || (temp > 1)) {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                "В двоичной системе счисления используются цифры от 0 до 1",
                                Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            answ = "";
                            break;
                        }
                        tempRes = (int) (temp * pow(2, step));
                        result = result + tempRes;
                        step++;
                        intNumb = intNumb / 10;
                        answ = Integer.toString(result);
                    } while (intNumb != 0);
                    edAnswer.setText(answ);
                }

                try{
                    if(popupmenu.getText() == "Из 2 в 16") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        answ = Integer.toHexString(Integer.parseInt(numb, 2));
                        edAnswer.setText(answ);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В двоичной системе счисления используются цифры от 0 до 1",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 8 в 2") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        answ = Integer.toBinaryString(Integer.parseInt(numb, 8));
                        edAnswer.setText(answ);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В восьмиричной системе счисления используются цифры от 0 до 7",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try{
                    if(popupmenu.getText() == "Из 8 в 10") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        intNumb = Integer.parseInt(numb);
                        do {
                            temp = intNumb % 10;
                            if ((temp < -7) || (temp > 7)) {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "В восьмиричной системе счисления используются цифры от 0 до 7",
                                        Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();
                                answ = "";
                                break;
                            }
                            tempRes = (int) (temp * pow(8, step));
                            result = result + tempRes;
                            step++;
                            intNumb = intNumb / 10;
                            answ = Integer.toString(result);
                        } while (intNumb != 0);
                        edAnswer.setText(answ);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В восьмиричной системе счисления используются цифры от 0 до 7",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 8 в 16") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        answ = Integer.toHexString(Integer.parseInt(numb, 8));
                        edAnswer.setText(answ);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В восьмиричной системе счисления используются цифры от 0 до 7",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 10 в 2") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        intNumb = Integer.parseInt(numb);
                        do {
                            answer.append(intNumb%2);
                            intNumb = intNumb/2;
                        } while (intNumb != 0);
                        edAnswer.setText(answer.reverse());
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В десятичнойй системе счисления используются цифры от 0 до 9",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 10 в 8") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        intNumb = Integer.parseInt(numb);
                        do {
                            answer.append(intNumb%8);
                            intNumb = intNumb/8;
                        } while (intNumb != 0);
                        edAnswer.setText(answer.reverse());
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В десятичнойй системе счисления используются цифры от 0 до 9",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 10 в 16") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        intNumb = Integer.parseInt(numb);
                        do {
                            temp = intNumb %16;
                                switch (temp) {
                                    case 10:
                                        sResult = sResult + "A";
                                        break;
                                    case 11:
                                        sResult = sResult + "B";
                                        break;
                                    case 12:
                                        sResult = sResult + "C";
                                        break;
                                    case 13:
                                        sResult = sResult + "D";
                                        break;
                                    case 14:
                                        sResult = sResult + "E";
                                        break;
                                    case 15:
                                        sResult = sResult + "F";
                                        break;
                                    case 16:
                                        sResult = sResult + "G";
                                        break;
                                    default:
                                        sResult = sResult + temp;
                                        break;
                                }
                            intNumb = intNumb/16;
                        } while (intNumb != 0);
                        answer.append(sResult);
                        edAnswer.setText(answer.reverse());
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В десятичнойй системе счисления используются цифры от 0 до 9",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 16 в 2") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        answ = Integer.toBinaryString(Integer.parseInt(numb, 16));
                        edAnswer.setText(answ);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В шестнадцатиричной системе счисления используются десятичные цифры от 0 до 9 и латинские буквы от A до F",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 16 в 8") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        answ = Integer.toOctalString(Integer.parseInt(numb, 16));
                        edAnswer.setText(answ);
                    }
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В шестнадцатиричной системе счисления используются десятичные цифры от 0 до 9 и латинские буквы от A до F",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                try {
                    if(popupmenu.getText() == "Из 16 в 10") {
                        edAnswer = (TextView) findViewById(R.id.edAnswer);
                        number = (EditText) findViewById(R.id.edNumber);
                        numb = number.getText().toString();
                        answ = Integer.toString(Integer.parseInt(numb, 16));
                        edAnswer.setText(answ);
                    }
                }catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "В шестнадцатиричной системе счисления используются десятичные цифры от 0 до 9 и латинские буквы от A до F",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                break;
//Реализация выхода из приложения
            case R.id.btnExit:
                exitDialog.show();
            default:
                break;
        }
    }

//Всплывающее меню

    private void showPopupMenu (View v) {
        final PopupMenu popupMenu = new PopupMenu(ScaleOfNotation.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.scale2to8:
                        popupmenu.setText("Из 2 в 8");
                        return true;

                    case R.id.scale2to10:
                        popupmenu.setText("Из 2 в 10");
                        return true;

                    case R.id.scale2to16:
                        popupmenu.setText("Из 2 в 16");
                        return true;

                    case R.id.scale8to2:
                        popupmenu.setText("Из 8 в 2");
                        return true;

                    case R.id.scale8to10:
                        popupmenu.setText("Из 8 в 10");
                        return true;

                    case R.id.scale8to16:
                        popupmenu.setText("Из 8 в 16");
                        return true;

                    case R.id.scale10to2:
                        popupmenu.setText("Из 10 в 2");
                        return true;

                    case R.id.scale10to8:
                        popupmenu.setText("Из 10 в 8");
                        return true;

                    case R.id.scale10to16:
                        popupmenu.setText("Из 10 в 16");
                        return true;

                    case R.id.scale16to2:
                        popupmenu.setText("Из 16 в 2");
                        return true;

                    case R.id.scale16to8:
                        popupmenu.setText("Из 16 в 8");
                        return true;

                    case R.id.scale16to10:
                        popupmenu.setText("Из 16 в 10");
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }
}