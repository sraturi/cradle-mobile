package com.cradle.neptune.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cradle.neptune.R;
import com.cradle.neptune.model.Patient.Patient;
import com.cradle.neptune.view.PatientProfileActivity;

import java.util.List;

public class PatientsViewAdapter extends RecyclerView.Adapter<PatientsViewAdapter.PatientViewHolder> {
    private List<Patient> patientList;
    private Context context;

    public PatientsViewAdapter(List<Patient> patientList, Context context) {
        this.patientList = patientList;
        this.context = context;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.patient_card, viewGroup, false);
        return new PatientViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder patientViewHolder, int i) {
        Patient patient = patientList.get(i);

        patientViewHolder.patientVillage.setText(patient.villageNumber);
        patientViewHolder.patientName.setText(patient.patientName);
        patientViewHolder.patientId.setText(patient.patientId);

        patientViewHolder.patientCardview.setOnClickListener(view -> {

            Intent intent = new Intent(context, PatientProfileActivity.class);
            Patient p = patientList.get(i);
            intent.putExtra("key", p);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView patientName, patientVillage, patientId;
        CardView patientCardview;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            patientCardview = itemView.findViewById(R.id.patientCardview);
            patientId = itemView.findViewById(R.id.patientID);
            patientName = itemView.findViewById(R.id.patientName);
            patientVillage = itemView.findViewById(R.id.patientVillage);
        }
    }
}