package com.iswanriadi.bacapk2;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class KontrolInputActivity extends AppCompatActivity {

    private SwipeRefreshLayout mLayoutContainer;
    private TextView mTvJudul, mTvPesan;
    private Button mBtnProses, mBtnReset;
    private LinearLayout mLayoutCheckbox, mLayoutRadio, mLayoutToggle, mLayoutSpinner;
    private CheckBox mCbPil1, mCbPil2, mCbPil3;
    private RadioGroup mRdPil;
    private ToggleButton mTgNyalaMati;
    private Switch mSwcSwitch;
    private Spinner mSpnPil;
    private ArrayAdapter<String> adapterSpnPil;
    private ArrayList<String> listPil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontrol_input);

        mLayoutContainer = findViewById(R.id.layout_container);
        mTvJudul = findViewById(R.id.tv_judul);
        mTvPesan = findViewById(R.id.tv_pesan);
        mBtnProses = findViewById(R.id.btn_proses);
        mBtnReset = findViewById(R.id.btn_reset);
        mLayoutCheckbox = findViewById(R.id.layout_checkbox);
        mLayoutRadio = findViewById(R.id.layout_radio);
        mLayoutToggle = findViewById(R.id.layout_toggle);
        mLayoutSpinner = findViewById(R.id.layout_spinner);
        mCbPil1 = findViewById(R.id.cb_pil1);
        mCbPil2 = findViewById(R.id.cb_pil2);
        mCbPil3 = findViewById(R.id.cb_pil3);
        mRdPil = findViewById(R.id.rd_pil);
        mTgNyalaMati = findViewById(R.id.tg_nyala_mati);
        mSwcSwitch = findViewById(R.id.swc_switch);
        mSpnPil = findViewById(R.id.spn_pil);
        listPil = new ArrayList<>();
        listPil.add("Pilihan 1");
        listPil.add("Pilihan 2");
        listPil.add("Pilihan 3");

        final String judul = getIntent().getStringExtra("judul");
        mTvJudul.setText(judul);

        switch (judul) {
            case "CHECKBOX":
                mLayoutCheckbox.setVisibility(View.VISIBLE);
                mCbPil1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        pesanCheckbox("1", isChecked);
                    }
                });
                mCbPil2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        pesanCheckbox("2", isChecked);
                    }
                });
                mCbPil3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        pesanCheckbox("3", isChecked);
                    }
                });
                break;
            case "RADIO":
                mLayoutRadio.setVisibility(View.VISIBLE);
                mRdPil.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton rdPil = findViewById(checkedId);
                        switch (checkedId) {
                            case R.id.rd_pil1:
                                if (rdPil.isChecked()) {
                                    pesanRadio("1");
                                }
                                break;
                            case R.id.rd_pil2:
                                if (rdPil.isChecked()) {
                                    pesanRadio("2");
                                }
                                break;
                            case R.id.rd_pil3:
                                if (rdPil.isChecked()) {
                                    pesanRadio("3");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                });
                break;
            case "TOGGLE":
                mLayoutToggle.setVisibility(View.VISIBLE);
                mTgNyalaMati.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        pesanToggle("Toggle button", isChecked);
                    }
                });
                mSwcSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        pesanToggle("Switch", isChecked);
                    }
                });
                break;
            case "SPINNER":
                mLayoutSpinner.setVisibility(View.VISIBLE);
                adapterSpnPil = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listPil);
                adapterSpnPil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpnPil.setAdapter(adapterSpnPil);
                mSpnPil.setPrompt("Pilih...");
                mSpnPil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        pesanSpinner(mSpnPil.getItemAtPosition(position).toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                break;
            default:
                break;
        }

        mBtnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (judul) {
                    case "CHECKBOX":
                        String temp = mTvPesan.getText().toString();
                        mTvPesan.setText("Pilihan yang ditandai :");
                        if (mCbPil1.isChecked()) {
                            mTvPesan.append(" 1");
                        }
                        if (mCbPil2.isChecked()) {
                            mTvPesan.append(" 2");
                        }
                        if (mCbPil3.isChecked()) {
                            mTvPesan.append(" 3");
                        } else if (!mCbPil1.isChecked() && !mCbPil2.isChecked()) {
                            mTvPesan.append(" Tidak ada");
                        }
                        if (!temp.isEmpty()) {
                            mTvPesan.append("\n" + temp);
                        }
                        break;
                    case "RADIO":
                        String temp1 = mTvPesan.getText().toString();
                        mTvPesan.setText("Pilihan yang ditandai : ");
                        switch (mRdPil.getCheckedRadioButtonId()) {
                            case R.id.rd_pil1:
                                mTvPesan.append("1");
                                break;
                            case R.id.rd_pil2:
                                mTvPesan.append("2");
                                break;
                            case R.id.rd_pil3:
                                mTvPesan.append("3");
                                break;
                            default:
                                mTvPesan.append("Tidak ada");
                                break;
                        }
                        if (!temp1.isEmpty()) {
                            mTvPesan.append("\n" + temp1);
                        }
                        break;
                    case "TOGGLE":
                        String temp2 = mTvPesan.getText().toString();
                        if (mTgNyalaMati.isChecked()) {
                            mTvPesan.setText("Toggle button : Nyala");
                        } else {
                            mTvPesan.setText("Toggle button : Mati");
                        }
                        if (mSwcSwitch.isChecked()) {
                            mTvPesan.append("\nSwitch : Nyala");
                        } else {
                            mTvPesan.append("\nSwitch : Mati");
                        }
                        if (!temp2.isEmpty()) {
                            mTvPesan.append("\n" + temp2);
                        }
                        break;
                    case "SPINNER":
                        String temp3 = mTvPesan.getText().toString();
                        mTvPesan.setText(mSpnPil.getSelectedItem().toString() + " diproses");
                        if (!temp3.isEmpty()) {
                            mTvPesan.append("\n" + temp3);
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvPesan.setText("");
            }
        });

        mLayoutContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                switch (judul) {
                    case "CHECKBOX":
                        mCbPil1.setChecked(false);
                        mCbPil2.setChecked(false);
                        mCbPil3.setChecked(false);
                        break;
                    case "RADIO":
                        mRdPil.clearCheck();
                        break;
                    case "TOGGLE":
                        mTgNyalaMati.setChecked(false);
                        mSwcSwitch.setChecked(false);
                        break;
                    case "SPINNER":
                        mSpnPil.setSelection(0);
                        break;
                    default:
                        break;
                }
                mTvPesan.setText("");
                mLayoutContainer.setRefreshing(false);
            }
        });
    }

    private void pesanCheckbox(String pil, boolean checked) {
        String temp = mTvPesan.getText().toString();
        if (checked) {
            mTvPesan.setText("Pilihan " + pil + " ditandai");
        } else {
            mTvPesan.setText("Pilihan " + pil + " dihapus");
        }
        if (!temp.isEmpty()) {
            mTvPesan.append("\n" + temp);
        }
    }

    private void pesanRadio(String pil) {
        String temp = mTvPesan.getText().toString();
        mTvPesan.setText("Pilihan " + pil + " ditandai");
        if (!temp.isEmpty()) {
            mTvPesan.append("\n" + temp);
        }
    }

    private void pesanToggle(String toggle, boolean checked) {
        String temp = mTvPesan.getText().toString();
        if (checked) {
            mTvPesan.setText(toggle + " dinyalakan");
        } else {
            mTvPesan.setText(toggle + " dimatikan");
        }
        if (!temp.isEmpty()) {
            mTvPesan.append("\n" + temp);
        }
    }

    private void pesanSpinner(String pil) {
        String temp = mTvPesan.getText().toString();
        mTvPesan.setText(pil + " dipilih");
        if (!temp.isEmpty()) {
            mTvPesan.append("\n" + temp);
        }
    }
}
