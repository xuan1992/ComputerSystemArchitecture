//import org.apache.poi.hwpf.extractor.WordExtractor;


/*
 * 9/25 V1.1 have change mem status. when ix get data, mem would change status. by Danny*/

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hwpf.extractor.WordExtractor;



import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class MySimulator {
    int cur_instr = 0;
    char[] instruction = new char[16];
    String[] command;
    String PC_instruction;
    String [][] memory;	// computer memory
    int pc;
    int Ir;
    char [] cache;

    private JFrame frame;
    private JTextField txtValue;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField txtError;
    private JTextField txtInput;	// input dialog

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MySimulator window = new MySimulator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MySimulator() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1280, 1024);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        // GRPS 
        JLabel lblNewLabel = new JLabel("GRPS");
        lblNewLabel.setBounds(10, 11, 42, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("0");
        label.setBounds(10, 36, 15, 14);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("1");
        label_1.setBounds(10, 57, 26, 14);
        frame.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("2");
        label_2.setBounds(10, 80, 26, 14);
        frame.getContentPane().add(label_2);

        JLabel label_3 = new JLabel("3");
        label_3.setBounds(10, 105, 26, 14);
        frame.getContentPane().add(label_3);
        //GPRS button begin
        JRadioButton rdbtnNewRadioButton = new JRadioButton("");
        rdbtnNewRadioButton.setBounds(31, 36, 21, 14);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton radioButton = new JRadioButton("");
        radioButton.setBounds(53, 36, 21, 14);
        frame.getContentPane().add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("");
        radioButton_1.setBounds(76, 36, 21, 14);
        frame.getContentPane().add(radioButton_1);

        JRadioButton radioButton_2 = new JRadioButton("");
        radioButton_2.setBounds(98, 36, 21, 14);
        frame.getContentPane().add(radioButton_2);

        JRadioButton radioButton_3 = new JRadioButton("");
        radioButton_3.setBounds(121, 36, 21, 14);
        frame.getContentPane().add(radioButton_3);

        JRadioButton radioButton_4 = new JRadioButton("");
        radioButton_4.setBounds(143, 36, 21, 14);
        frame.getContentPane().add(radioButton_4);

        JRadioButton radioButton_5 = new JRadioButton("");
        radioButton_5.setBounds(166, 36, 21, 14);
        frame.getContentPane().add(radioButton_5);

        JRadioButton radioButton_6 = new JRadioButton("");
        radioButton_6.setBounds(188, 36, 21, 14);
        frame.getContentPane().add(radioButton_6);

        JRadioButton radioButton_7 = new JRadioButton("");
        radioButton_7.setBounds(211, 36, 21, 14);
        frame.getContentPane().add(radioButton_7);

        JRadioButton radioButton_8 = new JRadioButton("");
        radioButton_8.setBounds(238, 36, 21, 14);
        frame.getContentPane().add(radioButton_8);

        JRadioButton radioButton_9 = new JRadioButton("");
        radioButton_9.setBounds(261, 36, 21, 14);
        frame.getContentPane().add(radioButton_9);

        JRadioButton radioButton_10 = new JRadioButton("");
        radioButton_10.setBounds(284, 36, 21, 14);
        frame.getContentPane().add(radioButton_10);

        JRadioButton radioButton_11 = new JRadioButton("");
        radioButton_11.setBounds(306, 36, 21, 14);
        frame.getContentPane().add(radioButton_11);

        JRadioButton radioButton_12 = new JRadioButton("");
        radioButton_12.setBounds(328, 36, 21, 14);
        frame.getContentPane().add(radioButton_12);

        JRadioButton radioButton_13 = new JRadioButton("");
        radioButton_13.setBounds(351, 36, 21, 14);
        frame.getContentPane().add(radioButton_13);

        JRadioButton radioButton_14 = new JRadioButton("");
        radioButton_14.setBounds(373, 36, 21, 14);
        frame.getContentPane().add(radioButton_14);
        //GPRS button end

        //GPRS r1 button begin
        JRadioButton radioButton_15 = new JRadioButton("");
        radioButton_15.setBounds(31, 57, 21, 14);
        frame.getContentPane().add(radioButton_15);

        JRadioButton radioButton_16 = new JRadioButton("");
        radioButton_16.setBounds(53, 57, 21, 14);
        frame.getContentPane().add(radioButton_16);

        JRadioButton radioButton_17 = new JRadioButton("");
        radioButton_17.setBounds(76, 57, 21, 14);
        frame.getContentPane().add(radioButton_17);

        JRadioButton radioButton_18 = new JRadioButton("");
        radioButton_18.setBounds(98, 57, 21, 14);
        frame.getContentPane().add(radioButton_18);

        JRadioButton radioButton_19 = new JRadioButton("");
        radioButton_19.setBounds(121, 57, 21, 14);
        frame.getContentPane().add(radioButton_19);

        JRadioButton radioButton_20 = new JRadioButton("");
        radioButton_20.setBounds(143, 57, 21, 14);
        frame.getContentPane().add(radioButton_20);

        JRadioButton radioButton_21 = new JRadioButton("");
        radioButton_21.setBounds(166, 57, 21, 14);
        frame.getContentPane().add(radioButton_21);

        JRadioButton radioButton_22 = new JRadioButton("");
        radioButton_22.setBounds(188, 57, 21, 14);
        frame.getContentPane().add(radioButton_22);

        JRadioButton radioButton_23 = new JRadioButton("");
        radioButton_23.setBounds(211, 57, 21, 14);
        frame.getContentPane().add(radioButton_23);

        JRadioButton radioButton_24 = new JRadioButton("");
        radioButton_24.setBounds(238, 57, 21, 14);
        frame.getContentPane().add(radioButton_24);

        JRadioButton radioButton_25 = new JRadioButton("");
        radioButton_25.setBounds(261, 57, 21, 14);
        frame.getContentPane().add(radioButton_25);

        JRadioButton radioButton_26 = new JRadioButton("");
        radioButton_26.setBounds(284, 57, 21, 14);
        frame.getContentPane().add(radioButton_26);

        JRadioButton radioButton_27 = new JRadioButton("");
        radioButton_27.setBounds(306, 57, 21, 14);
        frame.getContentPane().add(radioButton_27);

        JRadioButton radioButton_28 = new JRadioButton("");
        radioButton_28.setBounds(328, 57, 21, 14);
        frame.getContentPane().add(radioButton_28);

        JRadioButton radioButton_29 = new JRadioButton("");
        radioButton_29.setBounds(351, 57, 21, 14);
        frame.getContentPane().add(radioButton_29);

        JRadioButton radioButton_30 = new JRadioButton("");
        radioButton_30.setBounds(373, 57, 21, 14);
        frame.getContentPane().add(radioButton_30);
        //GPRS r1 button end

        //GPRS r2 button begin
        JRadioButton radioButton_31 = new JRadioButton("");
        radioButton_31.setBounds(31, 80, 21, 14);
        frame.getContentPane().add(radioButton_31);

        JRadioButton radioButton_32 = new JRadioButton("");
        radioButton_32.setBounds(53, 80, 21, 14);
        frame.getContentPane().add(radioButton_32);

        JRadioButton radioButton_33 = new JRadioButton("");
        radioButton_33.setBounds(76, 80, 21, 14);
        frame.getContentPane().add(radioButton_33);

        JRadioButton radioButton_34 = new JRadioButton("");
        radioButton_34.setBounds(98, 80, 21, 14);
        frame.getContentPane().add(radioButton_34);

        JRadioButton radioButton_35 = new JRadioButton("");
        radioButton_35.setBounds(121, 80, 21, 14);
        frame.getContentPane().add(radioButton_35);

        JRadioButton radioButton_36 = new JRadioButton("");
        radioButton_36.setBounds(143, 80, 21, 14);
        frame.getContentPane().add(radioButton_36);

        JRadioButton radioButton_37 = new JRadioButton("");
        radioButton_37.setBounds(166, 80, 21, 14);
        frame.getContentPane().add(radioButton_37);

        JRadioButton radioButton_38 = new JRadioButton("");
        radioButton_38.setBounds(188, 80, 21, 14);
        frame.getContentPane().add(radioButton_38);

        JRadioButton radioButton_39 = new JRadioButton("");
        radioButton_39.setBounds(211, 80, 21, 14);
        frame.getContentPane().add(radioButton_39);

        JRadioButton radioButton_40 = new JRadioButton("");
        radioButton_40.setBounds(238, 80, 21, 14);
        frame.getContentPane().add(radioButton_40);

        JRadioButton radioButton_41 = new JRadioButton("");
        radioButton_41.setBounds(261, 80, 21, 14);
        frame.getContentPane().add(radioButton_41);

        JRadioButton radioButton_42 = new JRadioButton("");
        radioButton_42.setBounds(284, 80, 21, 14);
        frame.getContentPane().add(radioButton_42);

        JRadioButton radioButton_43 = new JRadioButton("");
        radioButton_43.setBounds(306, 80, 21, 14);
        frame.getContentPane().add(radioButton_43);

        JRadioButton radioButton_44 = new JRadioButton("");
        radioButton_44.setBounds(328, 80, 21, 14);
        frame.getContentPane().add(radioButton_44);

        JRadioButton radioButton_45 = new JRadioButton("");
        radioButton_45.setBounds(351, 80, 21, 14);
        frame.getContentPane().add(radioButton_45);

        JRadioButton radioButton_46 = new JRadioButton("");
        radioButton_46.setBounds(373, 80, 21, 14);
        frame.getContentPane().add(radioButton_46);
        //GPRS r1 button end

        //GPRS r2 button begin
        JRadioButton radioButton_47 = new JRadioButton("");
        radioButton_47.setBounds(31, 105, 21, 14);
        frame.getContentPane().add(radioButton_47);

        JRadioButton radioButton_48 = new JRadioButton("");
        radioButton_48.setBounds(53, 105, 21, 14);
        frame.getContentPane().add(radioButton_48);

        JRadioButton radioButton_49 = new JRadioButton("");
        radioButton_49.setBounds(76, 105, 21, 14);
        frame.getContentPane().add(radioButton_49);

        JRadioButton radioButton_50 = new JRadioButton("");
        radioButton_50.setBounds(98, 105, 21, 14);
        frame.getContentPane().add(radioButton_50);

        JRadioButton radioButton_51 = new JRadioButton("");
        radioButton_51.setBounds(121, 105, 21, 14);
        frame.getContentPane().add(radioButton_51);

        JRadioButton radioButton_52 = new JRadioButton("");
        radioButton_52.setBounds(143, 105, 21, 14);
        frame.getContentPane().add(radioButton_52);

        JRadioButton radioButton_53 = new JRadioButton("");
        radioButton_53.setBounds(166, 105, 21, 14);
        frame.getContentPane().add(radioButton_53);

        JRadioButton radioButton_54 = new JRadioButton("");
        radioButton_54.setBounds(188, 105, 21, 14);
        frame.getContentPane().add(radioButton_54);

        JRadioButton radioButton_55 = new JRadioButton("");
        radioButton_55.setBounds(211, 105, 21, 14);
        frame.getContentPane().add(radioButton_55);

        JRadioButton radioButton_56 = new JRadioButton("");
        radioButton_56.setBounds(238, 105, 21, 14);
        frame.getContentPane().add(radioButton_56);

        JRadioButton radioButton_57 = new JRadioButton("");
        radioButton_57.setBounds(261, 105, 21, 14);
        frame.getContentPane().add(radioButton_57);

        JRadioButton radioButton_58 = new JRadioButton("");
        radioButton_58.setBounds(284, 105, 21, 14);
        frame.getContentPane().add(radioButton_58);

        JRadioButton radioButton_59 = new JRadioButton("");
        radioButton_59.setBounds(306, 105, 21, 14);
        frame.getContentPane().add(radioButton_59);

        JRadioButton radioButton_60 = new JRadioButton("");
        radioButton_60.setBounds(328, 105, 21, 14);
        frame.getContentPane().add(radioButton_60);

        JRadioButton radioButton_61 = new JRadioButton("");
        radioButton_61.setBounds(351, 105, 21, 14);
        frame.getContentPane().add(radioButton_61);

        JRadioButton radioButton_62 = new JRadioButton("");
        radioButton_62.setBounds(373, 105, 21, 14);
        frame.getContentPane().add(radioButton_62);
        //GPRS r2 button end

        //IX 1 button begin
        JRadioButton radioButton_63 = new JRadioButton("");
        radioButton_63.setBounds(31, 165, 21, 14);
        frame.getContentPane().add(radioButton_63);

        JRadioButton radioButton_64 = new JRadioButton("");
        radioButton_64.setBounds(53, 165, 21, 14);
        frame.getContentPane().add(radioButton_64);

        JRadioButton radioButton_65 = new JRadioButton("");
        radioButton_65.setBounds(76, 165, 21, 14);
        frame.getContentPane().add(radioButton_65);

        JRadioButton radioButton_66 = new JRadioButton("");
        radioButton_66.setBounds(98, 165, 21, 14);
        frame.getContentPane().add(radioButton_66);

        JRadioButton radioButton_67 = new JRadioButton("");
        radioButton_67.setBounds(121, 165, 21, 14);
        frame.getContentPane().add(radioButton_67);

        JRadioButton radioButton_68 = new JRadioButton("");
        radioButton_68.setBounds(143, 165, 21, 14);
        frame.getContentPane().add(radioButton_68);

        JRadioButton radioButton_69 = new JRadioButton("");
        radioButton_69.setBounds(166, 165, 21, 14);
        frame.getContentPane().add(radioButton_69);

        JRadioButton radioButton_70 = new JRadioButton("");
        radioButton_70.setBounds(188, 165, 21, 14);
        frame.getContentPane().add(radioButton_70);

        JRadioButton radioButton_71 = new JRadioButton("");
        radioButton_71.setBounds(211, 165, 21, 14);
        frame.getContentPane().add(radioButton_71);

        JRadioButton radioButton_72 = new JRadioButton("");
        radioButton_72.setBounds(238, 165, 21, 14);
        frame.getContentPane().add(radioButton_72);

        JRadioButton radioButton_73 = new JRadioButton("");
        radioButton_73.setBounds(261, 165, 21, 14);
        frame.getContentPane().add(radioButton_73);

        JRadioButton radioButton_74 = new JRadioButton("");
        radioButton_74.setBounds(284, 165, 21, 14);
        frame.getContentPane().add(radioButton_74);

        JRadioButton radioButton_75 = new JRadioButton("");
        radioButton_75.setBounds(306, 165, 21, 14);
        frame.getContentPane().add(radioButton_75);

        JRadioButton radioButton_76 = new JRadioButton("");
        radioButton_76.setBounds(328, 165, 21, 14);
        frame.getContentPane().add(radioButton_76);

        JRadioButton radioButton_77 = new JRadioButton("");
        radioButton_77.setBounds(351, 165, 21, 14);
        frame.getContentPane().add(radioButton_77);

        JRadioButton radioButton_78 = new JRadioButton("");
        radioButton_78.setBounds(373, 165, 21, 14);
        frame.getContentPane().add(radioButton_78);
        //IX 1 button end

        //IX 1 button begin
        JRadioButton radioButton_79 = new JRadioButton("");
        radioButton_79.setBounds(31, 193, 21, 14);
        frame.getContentPane().add(radioButton_79);

        JRadioButton radioButton_80 = new JRadioButton("");
        radioButton_80.setBounds(53, 193, 21, 14);
        frame.getContentPane().add(radioButton_80);

        JRadioButton radioButton_81 = new JRadioButton("");
        radioButton_81.setBounds(76, 193, 21, 14);
        frame.getContentPane().add(radioButton_81);

        JRadioButton radioButton_82 = new JRadioButton("");
        radioButton_82.setBounds(98, 193, 21, 14);
        frame.getContentPane().add(radioButton_82);

        JRadioButton radioButton_83 = new JRadioButton("");
        radioButton_83.setBounds(121, 193, 21, 14);
        frame.getContentPane().add(radioButton_83);

        JRadioButton radioButton_84 = new JRadioButton("");
        radioButton_84.setBounds(143, 193, 21, 14);
        frame.getContentPane().add(radioButton_84);

        JRadioButton radioButton_85 = new JRadioButton("");
        radioButton_85.setBounds(166, 193, 21, 14);
        frame.getContentPane().add(radioButton_85);

        JRadioButton radioButton_86 = new JRadioButton("");
        radioButton_86.setBounds(188, 193, 21, 14);
        frame.getContentPane().add(radioButton_86);

        JRadioButton radioButton_87 = new JRadioButton("");
        radioButton_87.setBounds(211, 193, 21, 14);
        frame.getContentPane().add(radioButton_87);

        JRadioButton radioButton_88 = new JRadioButton("");
        radioButton_88.setBounds(238, 193, 21, 14);
        frame.getContentPane().add(radioButton_88);

        JRadioButton radioButton_89 = new JRadioButton("");
        radioButton_89.setBounds(261, 193, 21, 14);
        frame.getContentPane().add(radioButton_89);

        JRadioButton radioButton_90 = new JRadioButton("");
        radioButton_90.setBounds(284, 193, 21, 14);
        frame.getContentPane().add(radioButton_90);

        JRadioButton radioButton_91 = new JRadioButton("");
        radioButton_91.setBounds(306, 193, 21, 14);
        frame.getContentPane().add(radioButton_91);

        JRadioButton radioButton_92 = new JRadioButton("");
        radioButton_92.setBounds(328, 193, 21, 14);
        frame.getContentPane().add(radioButton_92);

        JRadioButton radioButton_93 = new JRadioButton("");
        radioButton_93.setBounds(351, 193, 21, 14);
        frame.getContentPane().add(radioButton_93);

        JRadioButton radioButton_94 = new JRadioButton("");
        radioButton_94.setBounds(373, 193, 21, 14);
        frame.getContentPane().add(radioButton_94);
        //IX 1 button end

        //IX 2 button end
        JRadioButton radioButton_95 = new JRadioButton("");
        radioButton_95.setBounds(31, 224, 21, 14);
        frame.getContentPane().add(radioButton_95);

        JRadioButton radioButton_96 = new JRadioButton("");
        radioButton_96.setBounds(53, 224, 21, 14);
        frame.getContentPane().add(radioButton_96);

        JRadioButton radioButton_97 = new JRadioButton("");
        radioButton_97.setBounds(76, 224, 21, 14);
        frame.getContentPane().add(radioButton_97);

        JRadioButton radioButton_98 = new JRadioButton("");
        radioButton_98.setBounds(98, 224, 21, 14);
        frame.getContentPane().add(radioButton_98);

        JRadioButton radioButton_99 = new JRadioButton("");
        radioButton_99.setBounds(121, 224, 21, 14);
        frame.getContentPane().add(radioButton_99);

        JRadioButton radioButton_100 = new JRadioButton("");
        radioButton_100.setBounds(143, 224, 21, 14);
        frame.getContentPane().add(radioButton_100);

        JRadioButton radioButton_101 = new JRadioButton("");
        radioButton_101.setBounds(166, 224, 21, 14);
        frame.getContentPane().add(radioButton_101);

        JRadioButton radioButton_102 = new JRadioButton("");
        radioButton_102.setBounds(188, 224, 21, 14);
        frame.getContentPane().add(radioButton_102);

        JRadioButton radioButton_103 = new JRadioButton("");
        radioButton_103.setBounds(211, 224, 21, 14);
        frame.getContentPane().add(radioButton_103);

        JRadioButton radioButton_104 = new JRadioButton("");
        radioButton_104.setBounds(238, 224, 21, 14);
        frame.getContentPane().add(radioButton_104);

        JRadioButton radioButton_105 = new JRadioButton("");
        radioButton_105.setBounds(261, 224, 21, 14);
        frame.getContentPane().add(radioButton_105);

        JRadioButton radioButton_106 = new JRadioButton("");
        radioButton_106.setBounds(284, 224, 21, 14);
        frame.getContentPane().add(radioButton_106);

        JRadioButton radioButton_107 = new JRadioButton("");
        radioButton_107.setBounds(306, 224, 21, 14);
        frame.getContentPane().add(radioButton_107);

        JRadioButton radioButton_108 = new JRadioButton("");
        radioButton_108.setBounds(328, 224, 21, 14);
        frame.getContentPane().add(radioButton_108);

        JRadioButton radioButton_109 = new JRadioButton("");
        radioButton_109.setBounds(351, 224, 21, 14);
        frame.getContentPane().add(radioButton_109);

        JRadioButton radioButton_110 = new JRadioButton("");
        radioButton_110.setBounds(373, 224, 21, 14);
        frame.getContentPane().add(radioButton_110);
        //IX 1 button end

        //MAR button begin
        JRadioButton radioButton_111 = new JRadioButton("");
        radioButton_111.setBounds(591, 36, 21, 14);
        frame.getContentPane().add(radioButton_111);

        JRadioButton radioButton_112 = new JRadioButton("");
        radioButton_112.setBounds(613, 36, 21, 14);
        frame.getContentPane().add(radioButton_112);

        JRadioButton radioButton_113 = new JRadioButton("");
        radioButton_113.setBounds(636, 36, 21, 14);
        frame.getContentPane().add(radioButton_113);

        JRadioButton radioButton_114 = new JRadioButton("");
        radioButton_114.setBounds(658, 36, 21, 14);
        frame.getContentPane().add(radioButton_114);

        JRadioButton radioButton_115 = new JRadioButton("");
        radioButton_115.setBounds(681, 36, 21, 14);
        frame.getContentPane().add(radioButton_115);

        JRadioButton radioButton_116 = new JRadioButton("");
        radioButton_116.setBounds(703, 36, 21, 14);
        frame.getContentPane().add(radioButton_116);

        JRadioButton radioButton_117 = new JRadioButton("");
        radioButton_117.setBounds(726, 36, 21, 14);
        frame.getContentPane().add(radioButton_117);

        JRadioButton radioButton_118 = new JRadioButton("");
        radioButton_118.setBounds(748, 36, 21, 14);
        frame.getContentPane().add(radioButton_118);

        JRadioButton radioButton_119 = new JRadioButton("");
        radioButton_119.setBounds(776, 36, 21, 14);
        frame.getContentPane().add(radioButton_119);

        JRadioButton radioButton_120 = new JRadioButton("");
        radioButton_120.setBounds(798, 36, 21, 14);
        frame.getContentPane().add(radioButton_120);

        JRadioButton radioButton_121 = new JRadioButton("");
        radioButton_121.setBounds(821, 36, 21, 14);
        frame.getContentPane().add(radioButton_121);

        JRadioButton radioButton_122 = new JRadioButton("");
        radioButton_122.setBounds(843, 36, 21, 14);
        frame.getContentPane().add(radioButton_122);

        JRadioButton radioButton_123 = new JRadioButton("");
        radioButton_123.setBounds(866, 36, 21, 14);
        frame.getContentPane().add(radioButton_123);

        JRadioButton radioButton_124 = new JRadioButton("");
        radioButton_124.setBounds(888, 36, 21, 14);
        frame.getContentPane().add(radioButton_124);

        JRadioButton radioButton_125 = new JRadioButton("");
        radioButton_125.setBounds(911, 36, 21, 14);
        frame.getContentPane().add(radioButton_125);

        JRadioButton radioButton_126 = new JRadioButton("");
        radioButton_126.setBounds(933, 36, 21, 14);
        frame.getContentPane().add(radioButton_126);
        //MAR button end

        //MBR button begin
        JRadioButton radioButton_127 = new JRadioButton("");
        radioButton_127.setBounds(591, 105, 21, 14);
        frame.getContentPane().add(radioButton_127);


        JRadioButton radioButton_128 = new JRadioButton("");
        radioButton_128.setBounds(613, 105, 21, 14);
        frame.getContentPane().add(radioButton_128);

        JRadioButton radioButton_129 = new JRadioButton("");
        radioButton_129.setBounds(636, 105, 21, 14);
        frame.getContentPane().add(radioButton_129);

        JRadioButton radioButton_130 = new JRadioButton("");
        radioButton_130.setBounds(658, 105, 21, 14);
        frame.getContentPane().add(radioButton_130);

        JRadioButton radioButton_131 = new JRadioButton("");
        radioButton_131.setBounds(681, 105, 21, 14);
        frame.getContentPane().add(radioButton_131);

        JRadioButton radioButton_132 = new JRadioButton("");
        radioButton_132.setBounds(703, 105, 21, 14);
        frame.getContentPane().add(radioButton_132);

        JRadioButton radioButton_133 = new JRadioButton("");
        radioButton_133.setBounds(726, 105, 21, 14);
        frame.getContentPane().add(radioButton_133);

        JRadioButton radioButton_134 = new JRadioButton("");
        radioButton_134.setBounds(748, 105, 21, 14);
        frame.getContentPane().add(radioButton_134);

        JRadioButton radioButton_135 = new JRadioButton("");
        radioButton_135.setBounds(776, 105, 21, 14);
        frame.getContentPane().add(radioButton_135);

        JRadioButton radioButton_136 = new JRadioButton("");
        radioButton_136.setBounds(798, 105, 21, 14);
        frame.getContentPane().add(radioButton_136);

        JRadioButton radioButton_137 = new JRadioButton("");
        radioButton_137.setBounds(821, 105, 21, 14);
        frame.getContentPane().add(radioButton_137);

        JRadioButton radioButton_138 = new JRadioButton("");
        radioButton_138.setBounds(843, 105, 21, 14);
        frame.getContentPane().add(radioButton_138);

        JRadioButton radioButton_139 = new JRadioButton("");
        radioButton_139.setBounds(866, 105, 21, 14);
        frame.getContentPane().add(radioButton_139);

        JRadioButton radioButton_140 = new JRadioButton("");
        radioButton_140.setBounds(888, 105, 21, 14);
        frame.getContentPane().add(radioButton_140);

        JRadioButton radioButton_141 = new JRadioButton("");
        radioButton_141.setBounds(911, 105, 21, 14);
        frame.getContentPane().add(radioButton_141);

        JRadioButton radioButton_142 = new JRadioButton("");
        radioButton_142.setBounds(933, 105, 21, 14);
        frame.getContentPane().add(radioButton_142);
        //MBR button end

        textField_6 = new JTextField();//MAR　value
        textField_6.setText("VALUE");
        textField_6.setColumns(10);
        textField_6.setBounds(971, 39, 60, 20);
        frame.getContentPane().add(textField_6);

        JButton button_6 = new JButton("DEPOSIT");//MAR deposit
        button_6.setBounds(1035, 36, 89, 23);
        frame.getContentPane().add(button_6);

        textField_7 = new JTextField();//MBR value
        textField_7.setText("VALUE");
        textField_7.setColumns(10);
        textField_7.setBounds(971, 104, 60, 20);
        frame.getContentPane().add(textField_7);

        JButton button_7 = new JButton("DEPOSIT");//MBR deposit
        button_7.setBounds(1035, 101, 89, 23);
        frame.getContentPane().add(button_7);

        JLabel lblMem = new JLabel("MEM");
        lblMem.setBounds(591, 165, 42, 14);
        frame.getContentPane().add(lblMem);

        JLabel lblIr = new JLabel("IR");
        lblIr.setBounds(591, 224, 42, 14);
        frame.getContentPane().add(lblIr);

        JLabel lblPc = new JLabel("PC");
        lblPc.setBounds(592, 280, 42, 14);
        frame.getContentPane().add(lblPc);

        //MEM button begin
        JRadioButton radioButton_143 = new JRadioButton("");
        radioButton_143.setBounds(591, 188, 21, 14);
        frame.getContentPane().add(radioButton_143);

        JRadioButton radioButton_144 = new JRadioButton("");
        radioButton_144.setBounds(613, 188, 21, 14);
        frame.getContentPane().add(radioButton_144);

        JRadioButton radioButton_145 = new JRadioButton("");
        radioButton_145.setBounds(636, 188, 21, 14);
        frame.getContentPane().add(radioButton_145);

        JRadioButton radioButton_146 = new JRadioButton("");
        radioButton_146.setBounds(658, 188, 21, 14);
        frame.getContentPane().add(radioButton_146);

        JRadioButton radioButton_147 = new JRadioButton("");
        radioButton_147.setBounds(681, 188, 21, 14);
        frame.getContentPane().add(radioButton_147);

        JRadioButton radioButton_148 = new JRadioButton("");
        radioButton_148.setBounds(703, 188, 21, 14);
        frame.getContentPane().add(radioButton_148);

        JRadioButton radioButton_149 = new JRadioButton("");
        radioButton_149.setBounds(726, 188, 21, 14);
        frame.getContentPane().add(radioButton_149);

        JRadioButton radioButton_150 = new JRadioButton("");
        radioButton_150.setBounds(748, 188, 21, 14);
        frame.getContentPane().add(radioButton_150);

        JRadioButton radioButton_151 = new JRadioButton("");
        radioButton_151.setBounds(776, 188, 21, 14);
        frame.getContentPane().add(radioButton_151);

        JRadioButton radioButton_152 = new JRadioButton("");
        radioButton_152.setBounds(798, 188, 21, 14);
        frame.getContentPane().add(radioButton_152);

        JRadioButton radioButton_153 = new JRadioButton("");
        radioButton_153.setBounds(821, 188, 21, 14);
        frame.getContentPane().add(radioButton_153);

        JRadioButton radioButton_154 = new JRadioButton("");
        radioButton_154.setBounds(843, 188, 21, 14);
        frame.getContentPane().add(radioButton_154);

        JRadioButton radioButton_155 = new JRadioButton("");
        radioButton_155.setBounds(866, 188, 21, 14);
        frame.getContentPane().add(radioButton_155);

        JRadioButton radioButton_156 = new JRadioButton("");
        radioButton_156.setBounds(888, 188, 21, 14);
        frame.getContentPane().add(radioButton_156);

        JRadioButton radioButton_157 = new JRadioButton("");
        radioButton_157.setBounds(911, 188, 21, 14);
        frame.getContentPane().add(radioButton_157);

        JRadioButton radioButton_158 = new JRadioButton("");
        radioButton_158.setBounds(933, 188, 21, 14);
        frame.getContentPane().add(radioButton_158);
        //MEM button end

        //IR start
        JRadioButton radioButton_159 = new JRadioButton("");
        radioButton_159.setBounds(591, 253, 21, 14);
        frame.getContentPane().add(radioButton_159);

        JRadioButton radioButton_160 = new JRadioButton("");
        radioButton_160.setBounds(613, 253, 21, 14);
        frame.getContentPane().add(radioButton_160);

        JRadioButton radioButton_161 = new JRadioButton("");
        radioButton_161.setBounds(636, 253, 21, 14);
        frame.getContentPane().add(radioButton_161);

        JRadioButton radioButton_162 = new JRadioButton("");
        radioButton_162.setBounds(658, 253, 21, 14);
        frame.getContentPane().add(radioButton_162);

        JRadioButton radioButton_163 = new JRadioButton("");
        radioButton_163.setBounds(681, 253, 21, 14);
        frame.getContentPane().add(radioButton_163);

        JRadioButton radioButton_164 = new JRadioButton("");
        radioButton_164.setBounds(703, 253, 21, 14);
        frame.getContentPane().add(radioButton_164);

        JRadioButton radioButton_165 = new JRadioButton("");
        radioButton_165.setBounds(726, 253, 21, 14);
        frame.getContentPane().add(radioButton_165);

        JRadioButton radioButton_166 = new JRadioButton("");
        radioButton_166.setBounds(748, 253, 21, 14);
        frame.getContentPane().add(radioButton_166);

        JRadioButton radioButton_167 = new JRadioButton("");
        radioButton_167.setBounds(776, 253, 21, 14);
        frame.getContentPane().add(radioButton_167);

        JRadioButton radioButton_168 = new JRadioButton("");
        radioButton_168.setBounds(798, 253, 21, 14);
        frame.getContentPane().add(radioButton_168);

        JRadioButton radioButton_169 = new JRadioButton("");
        radioButton_169.setBounds(821, 253, 21, 14);
        frame.getContentPane().add(radioButton_169);

        JRadioButton radioButton_170 = new JRadioButton("");
        radioButton_170.setBounds(843, 253, 21, 14);
        frame.getContentPane().add(radioButton_170);

        JRadioButton radioButton_171 = new JRadioButton("");
        radioButton_171.setBounds(866, 253, 21, 14);
        frame.getContentPane().add(radioButton_171);

        JRadioButton radioButton_172 = new JRadioButton("");
        radioButton_172.setBounds(888, 253, 21, 14);
        frame.getContentPane().add(radioButton_172);

        JRadioButton radioButton_173 = new JRadioButton("");
        radioButton_173.setBounds(911, 253, 21, 14);
        frame.getContentPane().add(radioButton_173);

        JRadioButton radioButton_174 = new JRadioButton("");
        radioButton_174.setBounds(933, 253, 21, 14);
        frame.getContentPane().add(radioButton_174);
        //IR end

        //IX button
        JLabel lblNewLabel_1 = new JLabel("IX");
        lblNewLabel_1.setBounds(10, 145, 15, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel label_4 = new JLabel("0");
        label_4.setBounds(10, 165, 15, 14);
        frame.getContentPane().add(label_4);

        JLabel label_5 = new JLabel("1");
        label_5.setBounds(10, 193, 15, 14);
        frame.getContentPane().add(label_5);

        JLabel label_6 = new JLabel("2");
        label_6.setBounds(10, 224, 15, 14);
        frame.getContentPane().add(label_6);
        //IX button end

        //PC button start
        JRadioButton radioButton_175 = new JRadioButton("");
        radioButton_175.setBounds(591, 301, 21, 14);
        frame.getContentPane().add(radioButton_175);

        JRadioButton radioButton_176 = new JRadioButton("");
        radioButton_176.setBounds(613, 301, 21, 14);
        frame.getContentPane().add(radioButton_176);

        JRadioButton radioButton_177 = new JRadioButton("");
        radioButton_177.setBounds(636, 301, 21, 14);
        frame.getContentPane().add(radioButton_177);

        JRadioButton radioButton_178 = new JRadioButton("");
        radioButton_178.setBounds(658, 301, 21, 14);
        frame.getContentPane().add(radioButton_178);

        JRadioButton radioButton_179 = new JRadioButton("");
        radioButton_179.setBounds(681, 301, 21, 14);
        frame.getContentPane().add(radioButton_179);

        JRadioButton radioButton_180 = new JRadioButton("");
        radioButton_180.setBounds(703, 301, 21, 14);
        frame.getContentPane().add(radioButton_180);

        JRadioButton radioButton_181 = new JRadioButton("");
        radioButton_181.setBounds(726, 301, 21, 14);
        frame.getContentPane().add(radioButton_181);

        JRadioButton radioButton_182 = new JRadioButton("");
        radioButton_182.setBounds(748, 301, 21, 14);
        frame.getContentPane().add(radioButton_182);

        JRadioButton radioButton_183 = new JRadioButton("");
        radioButton_183.setBounds(776, 301, 21, 14);
        frame.getContentPane().add(radioButton_183);

        JRadioButton radioButton_184 = new JRadioButton("");
        radioButton_184.setBounds(798, 301, 21, 14);
        frame.getContentPane().add(radioButton_184);

        JRadioButton radioButton_185 = new JRadioButton("");
        radioButton_185.setBounds(821, 301, 21, 14);
        frame.getContentPane().add(radioButton_185);

        JRadioButton radioButton_186 = new JRadioButton("");
        radioButton_186.setBounds(843, 301, 21, 14);
        frame.getContentPane().add(radioButton_186);

        JRadioButton radioButton_187 = new JRadioButton("");
        radioButton_187.setBounds(866, 301, 21, 14);
        frame.getContentPane().add(radioButton_187);

        JRadioButton radioButton_188 = new JRadioButton("");
        radioButton_188.setBounds(888, 301, 21, 14);
        frame.getContentPane().add(radioButton_188);

        JRadioButton radioButton_189 = new JRadioButton("");
        radioButton_189.setBounds(911, 301, 21, 14);
        frame.getContentPane().add(radioButton_189);

        JRadioButton radioButton_190 = new JRadioButton("");
        radioButton_190.setBounds(933, 301, 21, 14);
        frame.getContentPane().add(radioButton_190);

        //PC button end

        //Function button, run, ss and deposit
        JButton btnNewButton = new JButton("RUN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(24, 317, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnSs = new JButton("SS");

        btnSs.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {    //ss step by step
                                        //find opcode type, if()


                                        //instruction[i] = in.read();
                                        radioButton_159.setSelected(false);
                                        radioButton_160.setSelected(false);
                                        radioButton_161.setSelected(false);
                                        radioButton_162.setSelected(false);
                                        radioButton_163.setSelected(false);
                                        radioButton_164.setSelected(false);
                                        radioButton_165.setSelected(false);
                                        radioButton_166.setSelected(false);
                                        radioButton_167.setSelected(false);
                                        radioButton_168.setSelected(false);
                                        radioButton_169.setSelected(false);
                                        radioButton_170.setSelected(false);
                                        radioButton_171.setSelected(false);
                                        radioButton_172.setSelected(false);
                                        radioButton_173.setSelected(false);
                                        radioButton_174.setSelected(false);
                                        radioButton_175.setSelected(false);
                                        radioButton_176.setSelected(false);
                                        radioButton_177.setSelected(false);
                                        radioButton_178.setSelected(false);
                                        radioButton_179.setSelected(false);
                                        radioButton_180.setSelected(false);
                                        radioButton_181.setSelected(false);
                                        radioButton_182.setSelected(false);
                                        radioButton_183.setSelected(false);
                                        radioButton_184.setSelected(false);
                                        radioButton_185.setSelected(false);
                                        radioButton_186.setSelected(false);
                                        radioButton_187.setSelected(false);
                                        radioButton_188.setSelected(false);
                                        radioButton_189.setSelected(false);
                                        radioButton_190.setSelected(false);





                                        instruction = command[cur_instr].toCharArray();


                                        if (instruction[0] == '1') {
                                            radioButton_159.setSelected(true);
                                        }
                                        if (instruction[1] == '1') {
                                            radioButton_160.setSelected(true);
                                        }
                                        if (instruction[2] == '1') {
                                            radioButton_161.setSelected(true);
                                        }
                                        if (instruction[3] == '1') {
                                            radioButton_162.setSelected(true);
                                        }
                                        if (instruction[4] == '1') {
                                            radioButton_163.setSelected(true);
                                        }
                                        if (instruction[5] == '1') {
                                            radioButton_164.setSelected(true);
                                        }
                                        if (instruction[6] == '1') {
                                            radioButton_165.setSelected(true);
                                        }
                                        if (instruction[7] == '1') {
                                            radioButton_166.setSelected(true);
                                        }
                                        if (instruction[8] == '1') {
                                            radioButton_167.setSelected(true);
                                        }
                                        if (instruction[9] == '1') {
                                            radioButton_168.setSelected(true);
                                        }
                                        if (instruction[10] == '1') {
                                            radioButton_169.setSelected(true);
                                        }
                                        if (instruction[11] == '1') {
                                            radioButton_170.setSelected(true);
                                        }
                                        if (instruction[12] == '1') {
                                            radioButton_171.setSelected(true);
                                        }
                                        if (instruction[13] == '1') {
                                            radioButton_172.setSelected(true);
                                        }
                                        if (instruction[14] == '1') {
                                            radioButton_173.setSelected(true);
                                        }
                                        if (instruction[15] == '1') {
                                            radioButton_174.setSelected(true);
                                        }


                                        cur_instr = cur_instr + 1;
                                        if (cur_instr < command.length) {
                                            instruction = command[cur_instr].toCharArray();
                                            if (instruction[0] == '1') {
                                                radioButton_175.setSelected(true);
                                            }
                                            if (instruction[1] == '1') {
                                                radioButton_176.setSelected(true);
                                            }
                                            if (instruction[2] == '1') {
                                                radioButton_177.setSelected(true);
                                            }
                                            if (instruction[3] == '1') {
                                                radioButton_178.setSelected(true);
                                            }
                                            if (instruction[4] == '1') {
                                                radioButton_179.setSelected(true);
                                            }
                                            if (instruction[5] == '1') {
                                                radioButton_180.setSelected(true);
                                            }
                                            if (instruction[6] == '1') {
                                                radioButton_181.setSelected(true);
                                            }
                                            if (instruction[7] == '1') {
                                                radioButton_182.setSelected(true);
                                            }
                                            if (instruction[8] == '1') {
                                                radioButton_183.setSelected(true);
                                            }
                                            if (instruction[9] == '1') {
                                                radioButton_184.setSelected(true);
                                            }
                                            if (instruction[10] == '1') {
                                                radioButton_185.setSelected(true);
                                            }
                                            if (instruction[11] == '1') {
                                                radioButton_186.setSelected(true);
                                            }
                                            if (instruction[12] == '1') {
                                                radioButton_187.setSelected(true);
                                            }
                                            if (instruction[13] == '1') {
                                                radioButton_188.setSelected(true);
                                            }
                                            if (instruction[14] == '1') {
                                                radioButton_189.setSelected(true);
                                            }
                                            if (instruction[15] == '1') {
                                                radioButton_190.setSelected(true);
                                            }
                                        }




                                        int ssStatus=1;
                                        while(pc>0&&ssStatus!=0){
                                            char [] Findopcode = FindOpcode(Ir,command);	//error
                                            String opcode= new String(Findopcode);
                                            switch (opcode){

                                                case "000001":{
                                                    char [] Rcode =FindGrps(Ir,command);
                                                    char  I = FindI(Ir,command);
                                                    String Rregis= new String(Rcode);
                                                    if(I!='1'){ //direct memory index
                                                        if(Rregis.equals("00")){	// means Grps r0
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    rdbtnNewRadioButton.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_1.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_2.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_3.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_4.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_5.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_6.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_7.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_8.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_9.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_10.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_11.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_12.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_13.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_14.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("01")){// means Grps r1
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_15.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_16.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_17.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_18.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_19.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_20.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_21.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_22.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_23.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_24.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_25.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_26.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_27.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_28.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_29.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_30.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("10")){// means Grps r2
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_31.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_32.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_33.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_34.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_35.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_36.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_37.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_38.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_39.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_40.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_41.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_42.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_43.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_44.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_45.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_46.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("11")){// means Grps r3
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_47.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_48.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_49.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_50.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_51.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_52.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_53.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_54.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_55.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_56.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_57.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_58.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_59.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_60.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_61.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_62.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                    }
        		
                                                }


                                                case "000010":{
                                                    char [] Rcode =FindGrps(Ir,command);
                                                    char  I = FindI(Ir,command);
                                                    String Rregis= new String(Rcode);
                                                    if(I!='1'){ //direct memory index
                                                        if(Rregis.equals("00")){	// means Grps r0
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    rdbtnNewRadioButton.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_1.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_2.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_3.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_4.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_5.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_6.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_7.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_8.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_9.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_10.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_11.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_12.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_13.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_14.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("01")){// means Grps r1
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_15.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_16.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_17.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_18.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_19.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_20.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_21.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_22.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_23.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_24.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_25.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_26.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_27.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_28.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_29.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_30.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("10")){// means Grps r2
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_31.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_32.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_33.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_34.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_35.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_36.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_37.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_38.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_39.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_40.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_41.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_42.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_43.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_44.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_45.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_46.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("11")){// means Grps r3
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_47.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_48.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_49.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_50.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_51.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_52.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_53.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_54.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_55.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_56.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_57.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_58.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_59.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_60.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_61.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_62.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                    }

                                                    //case 2 finish
                                                }



                                                case "000011":{
                                                    char [] Rcode =FindGrps(Ir,command);
                                                    char  I = FindI(Ir,command);
                                                    String Rregis= new String(Rcode);
                                                    if(I!='1'){ //direct memory index
                                                        if(Rregis.equals("00")){	// means Grps r0
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    rdbtnNewRadioButton.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_1.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_2.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_3.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_4.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_5.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_6.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_7.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_8.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_9.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_10.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_11.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_12.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_13.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_14.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("01")){// means Grps r1
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_15.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_16.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_17.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_18.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_19.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_20.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_21.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_22.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_23.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_24.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_25.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_26.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_27.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_28.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_29.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_30.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("10")){// means Grps r2
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_31.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_32.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_33.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_34.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_35.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_36.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_37.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_38.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_39.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_40.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_41.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_42.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_43.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_44.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_45.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_46.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rregis.equals("11")){// means Grps r3
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_47.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_48.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_49.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_50.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_51.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_52.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_53.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_54.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_55.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_56.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_57.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_58.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_59.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_60.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_61.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_62.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                    }

                                                    //case 3 finish
                                                }



                                                case "101001":{	//opcode 41
                                                    char [] Rcode =FindGrps(Ir,command);
                                                    char  I = FindI(Ir,command);
                                                    char [] address = FindAddress(Ir,command);

                                                    String Rregis= new String(Rcode);
                                                    if(I=='1'){
                                                        if (Rregis.equals("01")){	//find ix0

                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_63.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_64.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_65.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_66.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_67.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_68.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_69.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_70.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_71.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_72.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_73.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_74.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_75.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_76.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_77.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_78.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rcode.equals("11")){	//find ix1
                                                            for (int i = 0; i <= 15; i++) {
                                                                {
                                                                    if (command[Ir].charAt(0) == '1') {
                                                                        radioButton_79.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(1) == '1') {
                                                                        radioButton_80.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(2) == '1') {
                                                                        radioButton_81.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(3) == '1') {
                                                                        radioButton_82.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(4) == '1') {
                                                                        radioButton_83.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(5) == '1') {
                                                                        radioButton_84.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(6) == '1') {
                                                                        radioButton_85.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(7) == '1') {
                                                                        radioButton_86.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(8) == '1') {
                                                                        radioButton_87.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(9) == '1') {
                                                                        radioButton_88.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(10) == '1') {
                                                                        radioButton_89.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(11) == '1') {
                                                                        radioButton_90.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(12) == '1') {
                                                                        radioButton_91.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(13) == '1') {
                                                                        radioButton_92.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(14) == '1') {
                                                                        radioButton_93.setSelected(true);
                                                                    }
                                                                    if (command[Ir].charAt(15) == '1') {
                                                                        radioButton_94.setSelected(true);
                                                                    }
                                                                    pc=pc-1;
                                                                    Ir=Ir+1;
                                                                }
                                                            }
                                                        }
                                                        else if(Rcode.equals("10")){	//find ix2
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (command[Ir].charAt(0) == '1') {
                                                                    radioButton_95.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(1) == '1') {
                                                                    radioButton_96.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(2) == '1') {
                                                                    radioButton_97.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(3) == '1') {
                                                                    radioButton_98.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(4) == '1') {
                                                                    radioButton_99.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(5) == '1') {
                                                                    radioButton_100.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(6) == '1') {
                                                                    radioButton_101.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(7) == '1') {
                                                                    radioButton_102.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(8) == '1') {
                                                                    radioButton_103.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(9) == '1') {
                                                                    radioButton_104.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(10) == '1') {
                                                                    radioButton_105.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(11) == '1') {
                                                                    radioButton_106.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(12) == '1') {
                                                                    radioButton_107.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(13) == '1') {
                                                                    radioButton_108.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(14) == '1') {
                                                                    radioButton_109.setSelected(true);
                                                                }
                                                                if (command[Ir].charAt(15) == '1') {
                                                                    radioButton_110.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                    }
                                                }




                                                case "101010":{	//opcode 42
                                                    char [] Rcode =FindGrps(Ir,command);
                                                    char  I = FindI(Ir,command);
                                                    char [] address = FindAddress(Ir,command);

                                                    String Rregis= new String(Rcode);
                                                    if(I=='1'){


                                                        MyJDia d = new MyJDia();
                                                        String mymessage = d.getMessage(frame, "input");//input from user,suggest 16 format

                                                        // cause input is dec, we need to change our original code to dec
                                                        int ori_dec= Integer.valueOf(command[Ir].toString(),2);
                                                        int mymessage_int=Integer.parseInt(mymessage);

                                                        int result_add = ori_dec+mymessage_int;
                                                        String result_add_bi = Integer.toBinaryString(result_add);
                                                        char [] result_add_ch = result_add_bi.toCharArray();
                                                       
                                                        // store data
                                                        if (Rregis.equals("01")){	//find ix0
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (result_add_ch[0] == '1') {
                                                                    radioButton_63.setSelected(true);
                                                                    radioButton_143.setSelected(true);
                                                                }
                                                                if (result_add_ch[1] == '1') {
                                                                    radioButton_64.setSelected(true);
                                                                    radioButton_144.setSelected(true);
                                                                }
                                                                if (result_add_ch[2] == '1') {
                                                                    radioButton_65.setSelected(true);
                                                                    radioButton_145.setSelected(true);
                                                                }
                                                                if (result_add_ch[3] == '1') {
                                                                    radioButton_66.setSelected(true);
                                                                    radioButton_146.setSelected(true);
                                                                }
                                                                if (result_add_ch[4] == '1') {
                                                                    radioButton_67.setSelected(true);
                                                                    radioButton_147.setSelected(true);
                                                                }
                                                                if (result_add_ch[5] == '1') {
                                                                    radioButton_68.setSelected(true);
                                                                    radioButton_148.setSelected(true);
                                                                }
                                                                if (result_add_ch[6] == '1') {
                                                                    radioButton_69.setSelected(true);
                                                                    radioButton_149.setSelected(true);
                                                                }
                                                                if (result_add_ch[7] == '1') {
                                                                    radioButton_70.setSelected(true);
                                                                    radioButton_150.setSelected(true);
                                                                }
                                                                if (result_add_ch[8] == '1') {
                                                                    radioButton_71.setSelected(true);
                                                                    radioButton_151.setSelected(true);
                                                                }
                                                                if (result_add_ch[9] == '1') {
                                                                    radioButton_72.setSelected(true);
                                                                    radioButton_152.setSelected(true);
                                                                }
                                                                if (result_add_ch[10] == '1') {
                                                                    radioButton_73.setSelected(true);
                                                                    radioButton_153.setSelected(true);
                                                                }
                                                                if (result_add_ch[11] == '1') {
                                                                    radioButton_74.setSelected(true);
                                                                    radioButton_154.setSelected(true);
                                                                }
                                                                if (result_add_ch[12] == '1') {
                                                                    radioButton_75.setSelected(true);
                                                                    radioButton_155.setSelected(true);
                                                                }
                                                                if (result_add_ch[13] == '1') {
                                                                    radioButton_76.setSelected(true);
                                                                    radioButton_156.setSelected(true);
                                                                }
                                                                if (result_add_ch[14] == '1') {
                                                                    radioButton_77.setSelected(true);
                                                                    radioButton_157.setSelected(true);
                                                                }
                                                                if (result_add_ch[15] == '1') {
                                                                    radioButton_78.setSelected(true);
                                                                    radioButton_157.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                        else if(Rcode.equals("11")){	//find ix1
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (result_add_ch[0] == '1') {
                                                                    radioButton_79.setSelected(true);
                                                                    radioButton_143.setSelected(true);
                                                                }
                                                                if (result_add_ch[1] == '1') {
                                                                    radioButton_80.setSelected(true);
                                                                    radioButton_144.setSelected(true);
                                                                }
                                                                if (result_add_ch[2] == '1') {
                                                                    radioButton_81.setSelected(true);
                                                                    radioButton_145.setSelected(true);
                                                                }
                                                                if (result_add_ch[3] == '1') {
                                                                    radioButton_82.setSelected(true);
                                                                    radioButton_146.setSelected(true);
                                                                }
                                                                if (result_add_ch[4] == '1') {
                                                                    radioButton_83.setSelected(true);
                                                                    radioButton_147.setSelected(true);
                                                                }
                                                                if (result_add_ch[5] == '1') {
                                                                    radioButton_84.setSelected(true);
                                                                    radioButton_148.setSelected(true);
                                                                }
                                                                if (result_add_ch[6] == '1') {
                                                                    radioButton_85.setSelected(true);
                                                                    radioButton_149.setSelected(true);
                                                                }
                                                                if (result_add_ch[7] == '1') {
                                                                    radioButton_86.setSelected(true);
                                                                    radioButton_150.setSelected(true);
                                                                }
                                                                if (result_add_ch[8] == '1') {
                                                                    radioButton_87.setSelected(true);
                                                                    radioButton_151.setSelected(true);
                                                                }
                                                                if (result_add_ch[9] == '1') {
                                                                    radioButton_88.setSelected(true);
                                                                    radioButton_152.setSelected(true);
                                                                }
                                                                if (result_add_ch[10] == '1') {
                                                                    radioButton_89.setSelected(true);
                                                                    radioButton_153.setSelected(true);
                                                                }
                                                                if (result_add_ch[11] == '1') {
                                                                    radioButton_90.setSelected(true);
                                                                    radioButton_154.setSelected(true);
                                                                }
                                                                if (result_add_ch[12] == '1') {
                                                                    radioButton_91.setSelected(true);
                                                                    radioButton_155.setSelected(true);
                                                                }
                                                                if (result_add_ch[13] == '1') {
                                                                    radioButton_92.setSelected(true);
                                                                    radioButton_156.setSelected(true);
                                                                }
                                                                if (result_add_ch[14] == '1') {
                                                                    radioButton_93.setSelected(true);
                                                                    radioButton_157.setSelected(true);
                                                                }
                                                                if (result_add_ch[15] == '1') {
                                                                    radioButton_94.setSelected(true);
                                                                    radioButton_158.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }

                                                        else if(Rcode.equals("10")){	//find ix2
                                                            for (int i = 0; i <= 15; i++) {
                                                                if (result_add_ch[0] == '1') {
                                                                    radioButton_95.setSelected(true);
                                                                    radioButton_143.setSelected(true);
                                                                }
                                                                if (result_add_ch[1] == '1') {
                                                                    radioButton_96.setSelected(true);
                                                                    radioButton_144.setSelected(true);
                                                                }
                                                                if (result_add_ch[2] == '1') {
                                                                    radioButton_97.setSelected(true);
                                                                    radioButton_145.setSelected(true);
                                                                }
                                                                if (result_add_ch[3] == '1') {
                                                                    radioButton_98.setSelected(true);
                                                                    radioButton_146.setSelected(true);
                                                                }
                                                                if (result_add_ch[4] == '1') {
                                                                    radioButton_99.setSelected(true);
                                                                    radioButton_147.setSelected(true);
                                                                }
                                                                if (result_add_ch[5] == '1') {
                                                                    radioButton_100.setSelected(true);
                                                                    radioButton_148.setSelected(true);
                                                                }
                                                                if (result_add_ch[6] == '1') {
                                                                    radioButton_101.setSelected(true);
                                                                    radioButton_149.setSelected(true);
                                                                }
                                                                if (result_add_ch[7] == '1') {
                                                                    radioButton_102.setSelected(true);
                                                                    radioButton_150.setSelected(true);
                                                                }
                                                                if (result_add_ch[8] == '1') {
                                                                    radioButton_103.setSelected(true);
                                                                    radioButton_151.setSelected(true);
                                                                }
                                                                if (result_add_ch[9] == '1') {
                                                                    radioButton_104.setSelected(true);
                                                                    radioButton_152.setSelected(true);
                                                                }
                                                                if (result_add_ch[10] == '1') {
                                                                    radioButton_105.setSelected(true);
                                                                    radioButton_153.setSelected(true);
                                                                }
                                                                if (result_add_ch[11] == '1') {
                                                                    radioButton_106.setSelected(true);
                                                                    radioButton_154.setSelected(true);
                                                                }
                                                                if (result_add_ch[12] == '1') {
                                                                    radioButton_107.setSelected(true);
                                                                    radioButton_155.setSelected(true);
                                                                }
                                                                if (result_add_ch[13] == '1') {
                                                                    radioButton_108.setSelected(true);
                                                                    radioButton_156.setSelected(true);
                                                                }
                                                                if (result_add_ch[14] == '1') {
                                                                    radioButton_109.setSelected(true);
                                                                    radioButton_157.setSelected(true);
                                                                }
                                                                if (result_add_ch[15] == '1') {
                                                                    radioButton_110.setSelected(true);
                                                                    radioButton_158.setSelected(true);
                                                                }
                                                                pc=pc-1;
                                                                Ir=Ir+1;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            ssStatus=0;
                                        }
                                        //Switch end

                                    }
                                }
        );
        btnSs.setBounds(153, 318, 89, 23);
        frame.getContentPane().add(btnSs);

        JButton btnDeposit = new JButton("DEPOSIT");	//GPRS deposit
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioButton.setSelected(false);
                rdbtnNewRadioButton.setSelected(false);
                radioButton_14.setSelected(false);
                radioButton_13.setSelected(false);
                radioButton_12.setSelected(false);
                radioButton_11.setSelected(false);
                radioButton_10.setSelected(false);
                radioButton_9.setSelected(false);
                radioButton_8.setSelected(false);
                radioButton_7.setSelected(false);
                radioButton_6.setSelected(false);
                radioButton_5.setSelected(false);
                radioButton_4.setSelected(false);
                radioButton_3.setSelected(false);
                radioButton_2.setSelected(false);
                radioButton_1.setSelected(false);

                String input = txtValue.getText();
                String bi_str = Integer.toBinaryString(Integer.parseInt(input));//dec to binary
                char[] ch = bi_str.toCharArray();
                int length = ch.length;
                int count = 0;

                if(count < length && ch[length - 1] == '1') {
                    radioButton_14.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 2] == '1') {
                    radioButton_13.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 3] == '1') {
                    radioButton_12.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 4] == '1') {
                    radioButton_11.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 5] == '1') {
                    radioButton_10.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 6] == '1') {
                    radioButton_9.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 7] == '1') {
                    radioButton_8.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 8] == '1') {
                    radioButton_7.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 9] == '1') {
                    radioButton_6.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 10] == '1') {
                    radioButton_5.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 11] == '1') {
                    radioButton_4.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 12] == '1') {
                    radioButton_3.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 13] == '1') {
                    radioButton_2.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 14] == '1') {
                    radioButton_1.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 15] == '1') {
                    radioButton.setSelected(true);
                }
                count ++;
                if(count < length && ch[length - 16] == '1') {
                    rdbtnNewRadioButton.setSelected(true);
                }
            }
        });
        btnDeposit.setBounds(461, 30, 89, 23);
        frame.getContentPane().add(btnDeposit);

        JButton btnDeposit_1 = new JButton("DEPOSIT"); //GPRS 1
        btnDeposit_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	radioButton_30.setSelected(false);
            	radioButton_29.setSelected(false);
                radioButton_28.setSelected(false);
                radioButton_27.setSelected(false);
                radioButton_26.setSelected(false);
                radioButton_25.setSelected(false);
                radioButton_24.setSelected(false);
                radioButton_23.setSelected(false);
                radioButton_22.setSelected(false);
                radioButton_21.setSelected(false);
                radioButton_20.setSelected(false);
                radioButton_19.setSelected(false);
                radioButton_18.setSelected(false);
                radioButton_17.setSelected(false);
                radioButton_16.setSelected(false);
                radioButton_15.setSelected(false);

                String input = textField.getText();
                String bi_str = Integer.toBinaryString(Integer.parseInt(input));//dec to binary
                char[] ch = bi_str.toCharArray();
                int length = ch.length;
                int count = 0;

                if(count < length && ch[length - 1] == '1') {
                    radioButton_30.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 2] == '1') {
                    radioButton_29.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 3] == '1') {
                    radioButton_28.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 4] == '1') {
                    radioButton_27.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 5] == '1') {
                    radioButton_26.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 6] == '1') {
                    radioButton_25.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 7] == '1') {
                    radioButton_24.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 8] == '1') {
                    radioButton_23.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 9] == '1') {
                    radioButton_22.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 10] == '1') {
                    radioButton_21.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 11] == '1') {
                    radioButton_20.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 12] == '1') {
                    radioButton_19.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 13] == '1') {
                    radioButton_18.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 14] == '1') {
                    radioButton_17.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 15] == '1') {
                    radioButton_16.setSelected(true);
                }
                count ++;
                if(count < length && ch[length - 16] == '1') {
                	radioButton_15.setSelected(true);
                }
            	
            }
        });
        btnDeposit_1.setBounds(461, 53, 89, 23);
        frame.getContentPane().add(btnDeposit_1);

        JButton button_1 = new JButton("DEPOSIT"); //GPRS 2
        
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                radioButton_46.setSelected(false);
                radioButton_45.setSelected(false);
                radioButton_44.setSelected(false);
                radioButton_43.setSelected(false);
                radioButton_42.setSelected(false);
                radioButton_41.setSelected(false);
                radioButton_40.setSelected(false);
                radioButton_39.setSelected(false);
                radioButton_38.setSelected(false);
                radioButton_37.setSelected(false);
                radioButton_36.setSelected(false);
                radioButton_35.setSelected(false);
                radioButton_34.setSelected(false);
                radioButton_33.setSelected(false);
                radioButton_32.setSelected(false);
                radioButton_31.setSelected(false);

                String input = textField_1.getText();
                String bi_str = Integer.toBinaryString(Integer.parseInt(input));//dec to binary
                char[] ch = bi_str.toCharArray();
                int length = ch.length;
                int count = 0;

                if(count < length && ch[length - 1] == '1') {
                    radioButton_46.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 2] == '1') {
                    radioButton_45.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 3] == '1') {
                    radioButton_44.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 4] == '1') {
                    radioButton_43.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 5] == '1') {
                    radioButton_42.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 6] == '1') {
                    radioButton_41.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 7] == '1') {
                    radioButton_40.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 8] == '1') {
                    radioButton_39.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 9] == '1') {
                    radioButton_38.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 10] == '1') {
                    radioButton_37.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 11] == '1') {
                    radioButton_36.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 12] == '1') {
                    radioButton_35.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 13] == '1') {
                    radioButton_34.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 14] == '1') {
                    radioButton_33.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 15] == '1') {
                    radioButton_32.setSelected(true);
                }
                count ++;
                if(count < length && ch[length - 16] == '1') {
                	radioButton_31.setSelected(true);
                }
            	
            }
        });
        button_1.setBounds(461, 76, 89, 23);
        frame.getContentPane().add(button_1);
        
        
        

        JButton button_2 = new JButton("DEPOSIT"); //GPRS 3
        
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                radioButton_62.setSelected(false);
                radioButton_61.setSelected(false);
                radioButton_60.setSelected(false);
                radioButton_59.setSelected(false);
                radioButton_58.setSelected(false);
                radioButton_57.setSelected(false);
                radioButton_56.setSelected(false);
                radioButton_55.setSelected(false);
                radioButton_54.setSelected(false);
                radioButton_53.setSelected(false);
                radioButton_52.setSelected(false);
                radioButton_51.setSelected(false);
                radioButton_50.setSelected(false);
                radioButton_49.setSelected(false);
                radioButton_48.setSelected(false);
                radioButton_47.setSelected(false);

                String input = textField_2.getText();
                String bi_str = Integer.toBinaryString(Integer.parseInt(input));//dec to binary
                char[] ch = bi_str.toCharArray();
                int length = ch.length;
                int count = 0;

                if(count < length && ch[length - 1] == '1') {
                    radioButton_62.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 2] == '1') {
                    radioButton_61.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 3] == '1') {
                    radioButton_60.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 4] == '1') {
                    radioButton_59.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 5] == '1') {
                    radioButton_58.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 6] == '1') {
                    radioButton_57.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 7] == '1') {
                    radioButton_56.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 8] == '1') {
                    radioButton_55.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 9] == '1') {
                    radioButton_54.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 10] == '1') {
                    radioButton_53.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 11] == '1') {
                    radioButton_52.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 12] == '1') {
                    radioButton_51.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 13] == '1') {
                    radioButton_50.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 14] == '1') {
                    radioButton_49.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 15] == '1') {
                    radioButton_48.setSelected(true);
                }
                count ++;
                if(count < length && ch[length - 16] == '1') {
                	radioButton_47.setSelected(true);
                }
            	
            }
        });
        
        button_2.setBounds(461, 101, 89, 23);
        frame.getContentPane().add(button_2);

        
        
        JButton button_3 = new JButton("DEPOSIT");	//IX button 1
        
        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                radioButton_78.setSelected(false);
                radioButton_77.setSelected(false);
                radioButton_76.setSelected(false);
                radioButton_75.setSelected(false);
                radioButton_74.setSelected(false);
                radioButton_73.setSelected(false);
                radioButton_72.setSelected(false);
                radioButton_71.setSelected(false);
                radioButton_70.setSelected(false);
                radioButton_69.setSelected(false);
                radioButton_68.setSelected(false);
                radioButton_67.setSelected(false);
                radioButton_66.setSelected(false);
                radioButton_65.setSelected(false);
                radioButton_64.setSelected(false);
                radioButton_63.setSelected(false);

                String input = textField_3.getText();
                String bi_str = Integer.toBinaryString(Integer.parseInt(input));//dec to binary
                char[] ch = bi_str.toCharArray();
                int length = ch.length;
                int count = 0;

                if(count < length && ch[length - 1] == '1') {
                    radioButton_78.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 2] == '1') {
                    radioButton_77.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 3] == '1') {
                    radioButton_76.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 4] == '1') {
                    radioButton_75.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 5] == '1') {
                    radioButton_74.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 6] == '1') {
                    radioButton_73.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 7] == '1') {
                    radioButton_72.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 8] == '1') {
                    radioButton_71.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 9] == '1') {
                    radioButton_70.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 10] == '1') {
                    radioButton_69.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 11] == '1') {
                    radioButton_68.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 12] == '1') {
                    radioButton_67.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 13] == '1') {
                    radioButton_66.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 14] == '1') {
                    radioButton_65.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 15] == '1') {
                    radioButton_64.setSelected(true);
                }
                count ++;
                if(count < length && ch[length - 16] == '1') {
                	radioButton_63.setSelected(true);
                }
            	
            }
        });
        button_3.setBounds(461, 165, 89, 23);
        frame.getContentPane().add(button_3);

        
        JButton button_4 = new JButton("DEPOSIT");//IX button2
        
        button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                radioButton_94.setSelected(false);
                radioButton_93.setSelected(false);
                radioButton_92.setSelected(false);
                radioButton_91.setSelected(false);
                radioButton_90.setSelected(false);
                radioButton_89.setSelected(false);
                radioButton_88.setSelected(false);
                radioButton_87.setSelected(false);
                radioButton_86.setSelected(false);
                radioButton_85.setSelected(false);
                radioButton_84.setSelected(false);
                radioButton_83.setSelected(false);
                radioButton_82.setSelected(false);
                radioButton_81.setSelected(false);
                radioButton_80.setSelected(false);
                radioButton_79.setSelected(false);

                String input = textField_4.getText();
                String bi_str = Integer.toBinaryString(Integer.parseInt(input));//dec to binary
                char[] ch = bi_str.toCharArray();
                int length = ch.length;
                int count = 0;

                if(count < length && ch[length - 1] == '1') {
                    radioButton_94.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 2] == '1') {
                    radioButton_93.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 3] == '1') {
                    radioButton_92.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 4] == '1') {
                    radioButton_91.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 5] == '1') {
                    radioButton_90.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 6] == '1') {
                    radioButton_89.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 7] == '1') {
                    radioButton_88.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 8] == '1') {
                    radioButton_87.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 9] == '1') {
                    radioButton_86.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 10] == '1') {
                    radioButton_85.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 11] == '1') {
                    radioButton_84.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 12] == '1') {
                    radioButton_83.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 13] == '1') {
                    radioButton_82.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 14] == '1') {
                    radioButton_81.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 15] == '1') {
                    radioButton_80.setSelected(true);
                }
                count ++;
                if(count < length && ch[length - 16] == '1') {
                	radioButton_79.setSelected(true);
                }
            	
            }
        });
        button_4.setBounds(461, 193, 89, 23);
        frame.getContentPane().add(button_4);

        
        JButton button_5 = new JButton("DEPOSIT"); //IX button3

        button_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                radioButton_110.setSelected(false);
                radioButton_109.setSelected(false);
                radioButton_108.setSelected(false);
                radioButton_107.setSelected(false);
                radioButton_106.setSelected(false);
                radioButton_105.setSelected(false);
                radioButton_104.setSelected(false);
                radioButton_103.setSelected(false);
                radioButton_102.setSelected(false);
                radioButton_101.setSelected(false);
                radioButton_100.setSelected(false);
                radioButton_99.setSelected(false);
                radioButton_98.setSelected(false);
                radioButton_97.setSelected(false);
                radioButton_96.setSelected(false);
                radioButton_95.setSelected(false);

                String input = textField_5.getText();
                String bi_str = Integer.toBinaryString(Integer.parseInt(input));//dec to binary
                char[] ch = bi_str.toCharArray();
                int length = ch.length;
                int count = 0;

                if(count < length && ch[length - 1] == '1') {
                    radioButton_110.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 2] == '1') {
                    radioButton_109.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 3] == '1') {
                    radioButton_108.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 4] == '1') {
                    radioButton_107.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 5] == '1') {
                    radioButton_106.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 6] == '1') {
                    radioButton_105.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 7] == '1') {
                    radioButton_104.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 8] == '1') {
                    radioButton_103.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 9] == '1') {
                    radioButton_102.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 10] == '1') {
                    radioButton_101.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 11] == '1') {
                    radioButton_100.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 12] == '1') {
                    radioButton_99.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 13] == '1') {
                    radioButton_98.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 14] == '1') {
                    radioButton_97.setSelected(true);
                }
                count++;
                if(count < length && ch[length - 15] == '1') {
                    radioButton_96.setSelected(true);
                }
                count ++;
                if(count < length && ch[length - 16] == '1') {
                	radioButton_95.setSelected(true);
                }
            	
            }
        });
        button_5.setBounds(461, 215, 89, 23);
        frame.getContentPane().add(button_5);

        txtValue = new JTextField();	//GRPs0
        txtValue.setText("VALUE");
        txtValue.setBounds(397, 33, 60, 20);
        frame.getContentPane().add(txtValue);
        txtValue.setColumns(10);

        textField = new JTextField();//GRPs1
        textField.setText("VALUE");
        textField.setColumns(10);
        textField.setBounds(397, 54, 60, 20);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField();//GRPs2
        textField_1.setText("VALUE");
        textField_1.setColumns(10);
        textField_1.setBounds(397, 77, 60, 20);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();//GRPs3
        textField_2.setText("VALUE");
        textField_2.setColumns(10);
        textField_2.setBounds(397, 102, 60, 20);
        frame.getContentPane().add(textField_2);

        textField_3 = new JTextField();//IX1
        textField_3.setText("VALUE");
        textField_3.setColumns(10);
        textField_3.setBounds(400, 165, 60, 20);
        frame.getContentPane().add(textField_3);

        textField_4 = new JTextField();//IX2
        textField_4.setText("VALUE");
        textField_4.setColumns(10);
        textField_4.setBounds(400, 193, 60, 20);
        frame.getContentPane().add(textField_4);

        textField_5 = new JTextField();//IX3
        textField_5.setText("VALUE");
        textField_5.setColumns(10);
        textField_5.setBounds(400, 218, 60, 20);
        frame.getContentPane().add(textField_5);

        JLabel lblMar = new JLabel("MAR");
        lblMar.setBounds(591, 11, 42, 14);
        frame.getContentPane().add(lblMar);

        JLabel lblMbr = new JLabel("MBR");
        lblMbr.setBounds(591, 76, 42, 14);
        frame.getContentPane().add(lblMbr);

        textField_8 = new JTextField();
        textField_8.setText("VALUE");
        textField_8.setColumns(10);
        textField_8.setBounds(971, 187, 60, 20);
        frame.getContentPane().add(textField_8);

        JButton button_8 = new JButton("DEPOSIT");
        button_8.setBounds(1035, 184, 89, 23);
        frame.getContentPane().add(button_8);



        textField_9 = new JTextField();	//IR value
        textField_9.setText("VALUE");
        textField_9.setColumns(10);
        textField_9.setBounds(971, 252, 60, 20);
        frame.getContentPane().add(textField_9);

        JButton button_9 = new JButton("DEPOSIT");	//IR deposit
        button_9.setBounds(1035, 249, 89, 23);
        frame.getContentPane().add(button_9);

        textField_10 = new JTextField();//pc value
        textField_10.setText("VALUE");
        textField_10.setColumns(10);
        textField_10.setBounds(971, 300, 60, 20);
        frame.getContentPane().add(textField_10);

        JButton button_10 = new JButton("DEPOSIT");//pc deposit
        button_10.setBounds(1035, 297, 89, 23);
        frame.getContentPane().add(button_10);

        JButton btnIpl = new JButton("IPL");
        btnIpl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                InputStream in = null;

                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Please select input data");
                chooser.setMultiSelectionEnabled(true);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("doc", "doc");//choose doc file
                chooser.setFileFilter(filter);

                chooser.showOpenDialog(null);

                try {
                    //initial program
                    File file = chooser.getSelectedFile();
                    in = new FileInputStream(file);
                    WordExtractor ex = new WordExtractor(in);
                    String text = ex.getText();
                    command = text.split("\n|\r\n");

                    int num_Command = command.length;
                    pc=command.length;//instruction length
                    Ir=0;

                    //initial program end
                    if (num_Command == 0) {
                        return;
                    }
                  
                
                    /*
                    for (int i = 0; i <= 15; i++) {
                        //instruction[i] = in.read();
                        instruction[i] = command[1].charAt(i);
                        PC_instruction = command[1];
                        if (instruction[0] == '1') {
                            radioButton_175.setSelected(true);
                        }
                        if (instruction[1] == '1') {
                            radioButton_176.setSelected(true);
                        }
                        if (instruction[2] == '1') {
                            radioButton_177.setSelected(true);
                        }
                        if (instruction[3] == '1') {
                            radioButton_178.setSelected(true);
                        }
                        if (instruction[4] == '1') {
                            radioButton_179.setSelected(true);
                        }
                        if (instruction[5] == '1') {
                            radioButton_180.setSelected(true);
                        }
                        if (instruction[6] == '1') {
                            radioButton_181.setSelected(true);
                        }
                        if (instruction[7] == '1') {
                            radioButton_182.setSelected(true);
                        }
                        if (instruction[8] == '1') {
                            radioButton_183.setSelected(true);
                        }
                        if (instruction[9] == '1') {
                            radioButton_184.setSelected(true);
                        }
                        if (instruction[10] == '1') {
                            radioButton_185.setSelected(true);
                        }
                        if (instruction[11] == '1') {
                            radioButton_186.setSelected(true);
                        }
                        if (instruction[12] == '1') {
                            radioButton_187.setSelected(true);
                        }
                        if (instruction[13] == '1') {
                            radioButton_188.setSelected(true);
                        }
                        if (instruction[14] == '1') {
                            radioButton_189.setSelected(true);
                        }
                        if (instruction[15] == '1') {
                            radioButton_190.setSelected(true);
                        }
                    }
                    */
                    in.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }

            }
        });
        btnIpl.setBounds(298, 318, 89, 23);
        frame.getContentPane().add(btnIpl);

        txtError = new JTextField();
        txtError.setText("error");
        txtError.setBounds(27, 377, 86, 20);
        frame.getContentPane().add(txtError);
        txtError.setColumns(10);


    }
    // split OPcode, return char or string
    public char [] FindOpcode(int i, String [] command){	//i = pc, means the index of pc. however, begin in 0;
        String binary;
        //binary=String.valueOf(command[i].charAt(0)+command[i].charAt(1)+command[i].charAt(2)
        //		+command[i].charAt(3)+command[i].charAt(4)+command[i].charAt(5));// to Dec
        // error

        //	String is =Integer.valueOf(binary,2).toString();// dont know
        char [] is = new char [6];
        is[0]= command[i].charAt(0);
        is[1]=command[i].charAt(1);
        is[2]=command[i].charAt(2);
        is[3]=command[i].charAt(3);
        is[4]=command[i].charAt(4);
        is[5]=command[i].charAt(5);
        return is;
    }

    public char [] FindGrps(int i, String [] command){
        char [] Rcode=new char [2];
        Rcode[0]=command[i].charAt(6);
        Rcode[1]=command[i].charAt(7);
        return Rcode;
    }
    public char FindI(int i, String [] command){
        char I = command[i].charAt(10);
        return I;
    }
    public char [] FindIndex(int i, String [] command){
        char [] Index=new char [2];
        Index[0]=command[i].charAt(8);
        Index[1]=command[i].charAt(9);
        return Index;
    }
    public char [] FindAddress(int i, String [] command){
        char [] Address= new char[5]; // Address has 5 index.
        Address[0]=command[i].charAt(11);
        Address[1]=command[i].charAt(12);
        Address[2]=command[i].charAt(13);
        Address[3]=command[i].charAt(14);
        Address[4]=command[i].charAt(15);
        return Address;
    }
}

