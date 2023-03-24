import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton submitButton;
    private JPanel Arifin;
    private JTextArea textArea1;

    public GUI() {
        setContentPane(Arifin);
        setTitle("Daftar Barang");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        GUI tm = new GUI();
        ConnectURI koneksiSaya = new ConnectURI();
        URL myAddress = koneksiSaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksiSaya.getResponseFromHttpurl(myAddress);
        System.out.println(response);

        assert response != null;
        JSONArray responsJSON = new JSONArray(response);
        ArrayList<Model> model = new ArrayList<>();
        for (int i = 0; i < responsJSON.length(); i++) {
            Model responModel = new Model();
            JSONObject myJSONobject = responsJSON.getJSONObject(i);
            responModel.setI_name(myJSONobject.getString("i_name"));
            responModel.setI_qty(myJSONobject.getString("i_qty"));
            responModel.setI_sell(myJSONobject.getString("i_sell"));
            model.add(responModel);
        }
        System.out.println("Response are");
        for (int index = 0; index < model.size(); index++) {
            System.out.println("NAMA : " + model.get(index).getI_name());
            System.out.println("QTY : " + model.get(index).getI_qty());
            System.out.println("SELL : " + model.get(index).getI_sell());
        }

        tm.submitButton.addActionListener(e ->  {
//            @Override
            for (int index = 0; index < model.size(); index++) {
                int harga = Integer.parseInt(model.get(index).getI_sell());
                String nama = String.valueOf(model.get(index).getI_name());
                String stok = model.get(index).getI_qty();
                if (nama.contains("s") && harga < 7000 && stok != null) {
                    tm.textArea1.append("nama barang : " + nama + "\nHarga : " + harga + "\nstok : " + stok + "\n");


                }
            }
        });
    }
}

