package com.example.planetquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.planetquiz.databinding.FragmentQuestionsBinding;

public class QuestionsFragment extends Fragment {

    private FragmentQuestionsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentQuestionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnQuestion1.setOnClickListener(v -> navigateToQuestion(0));
        binding.btnQuestion2.setOnClickListener(v -> navigateToQuestion(1));
        binding.btnQuestion3.setOnClickListener(v -> navigateToQuestion(2));
    }

    private void navigateToQuestion(int questionIndex) {
        Bundle bundle = new Bundle();
        bundle.putInt("questionIndex", questionIndex);
        Navigation.findNavController(requireView())
                .navigate(R.id.action_questionsFragment_to_multipleChoiceFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
