package lili.tesla.leongardtest.presentation.screen.results.presenter;

import lili.tesla.leongardtest.presentation.application.App;
import lili.tesla.leongardtest.presentation.screen.base.BasePresenter;
import lili.tesla.leongardtest.presentation.screen.results.view.ResultsView;

/**
 * Created by Лилия on 12.11.2017.
 */

public class ResultsPresenter extends BasePresenter<ResultsView> {

    private int[] scales = new int[10];
    private final String sTextColor = "#00BCD4";

    private int colLow;
    private int colMedium;
    private int colHigh;

    public void showResults() {

        findAllValues();
        findAllLevels();

        String sResult = "";

        sResult += "<FONT COLOR=" + sTextColor + "><b>Анализ профиля</b><br><br></font>";

        if ((colHigh == 1) || (colHigh == 2)) {
            sResult += "На общем «ровном» фоне средних и низких показателей выделяется одно или два ярко выраженных значения." +
                    " В этом случае можно вести речь о выраженном типе акцентуации, либо о склонности вести себя в соответствии с основными характеристиками этого типа.<br><br>";
        } else {
            if (colHigh > 5) {
                sResult += "Большинство значений оказались на уровне или выше 19-ти баллов. По всей вероятности, перед нами сложный в общении человек, со многими «острыми» " +
                        "углами, но, безусловно – это яркая личность. Если отдельные черты достигли отметки 22 и выше баллов, то налицо явные акцентуации. Согласно концепции" +
                        " К. Леонгарда, наличие акцентуаций еще не является признаком патологии, а свидетельствует об определенном потенциале личности и характерной манере ее " +
                        "взаимодействия с людьми.<br><br>";

            } else {
                if ((colLow > 7) && (colHigh == 0)) {
                    sResult += "Все или практически все точки на графике оказались в зоне низких значений (0–6 баллов). Такие показатели могут характеризовать личность," +
                            " которая всеми силами хочется показаться социально нормативной, «хорошей», как ей это кажется. Обычно такие люди демонстрируют сниженную " +
                            "самокритичность, ведут себя претенциозно, неискренни, иногда оказываются демонстративными особами. Также, подобные результаты может дать " +
                            "пассивный человек, который старается быть неприметным и не стремится к высоким достижениям.<br><br>";
                } else {
                    if ((colLow > 0) && (colHigh > 0) && (colMedium > 0))
                    sResult += "Графическая кривая имеет отчетливый «зубчатый» профиль – высокие и низкие показатели чередуются. Такой график встречается чаще всего " +
                            "и требует особого внимания при интерпретации, ибо за отдельными показателями может скрываться как вполне адекватный, «живой» человек, " +
                            "со своими характерологическими достоинствами и недостатками, так и человек, весьма проблемный в коммуникативном и воспитательном плане.<br><br>";
                }
            }

        }

        sResult += "<FONT COLOR=" + sTextColor + "><b>Значения шкал</b><br><br></font>";

        for (int i = 1; i < 10; i++) {
            sResult += App.dataBaseAccess.getScale(i, scales[i]);
        }

        sResult += "<FONT COLOR=" + sTextColor + "><b>Сочетания типов</b><br><br></font>";

        mView.showResults(sResult);
    }

    private void findAllLevels() {
        colLow = 0;
        colMedium = 0;
        colHigh = 0;

        for (int i = 0; i < 10; i++) {
            if (scales[i] < 7) {
                colLow ++;
            } else {
                if (scales[i] > 18) {
                    colHigh ++;
                } else {
                    colMedium ++;
                }
            }
        }

    }

    private void findAllValues() {

        for (int i = 0; i < 10; i++) {
            scales[i] = 0;
        }

        String[] scale_positive = new String[] {
                " 6 18 28 40 50 62 72 84 ",
                " 7 19 22 29 41 44 63 66 73 85 88 ",
                " 2 15 24 34 37 56 68 78 81 ",
                " 4 14 17 26 39 48 58 61 70 80 83 ",
                " 8 20 30 42 52 64 74 86 ",
                " 1 11 23 33 45 55 67 77 ",
                " 9 21 43 75 87 ",
                " 16 27 38 49 60 71 82 ",
                " 10 32 54 76 ",
                " 3 13 35 47 57 69 79 "};

        String[] scale_negative = new String[] {
                " 51 ",
                " 12 46 59 ",
                " 36 ",
                " ",
                " ",
                " 31 53 65 ",
                " 5 ",
                " ",
                " 25 ",
                " "};


        for ( int i = 0; i < 88; i++ ) {

            if (App.questions.get(i).isAnswer()) {

                for (int j = 0; j < 10; j++) {
                    if (scale_positive[j].contains(" " + i + " ")) {
                        scales[j] ++;
                    }
                }

            } else {

                for (int j = 0; j < 10; j++) {
                    if (scale_negative[j].contains(" " + i + " ")) {
                        scales[j] ++;
                    }
                }

            }
        }

        for (int i = 0; i < 3; i++) { scales[i] *= 2; }
        for (int i = 3; i < 7; i++) { scales[i] *= 3; }
        scales[7] *= 6;
        scales[8] *= 3;
        scales[9  ] *= 3;

    }

}
