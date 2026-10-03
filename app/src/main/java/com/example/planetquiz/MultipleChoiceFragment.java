package com.example.planetquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.planetquiz.databinding.FragmentMultipleChoiceBinding;

public class MultipleChoiceFragment extends Fragment {

    private FragmentMultipleChoiceBinding binding;
    private Question question;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMultipleChoiceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int questionIndex = 0;
        if (getArguments() != null) {
            questionIndex = getArguments().getInt("questionIndex", 0);
        }

        question = QuizRepository.getQuestion(questionIndex);
        binding.tvQuestionTitle.setText(question.getQuestionResId());

        binding.btnMercury.setOnClickListener(v -> checkAnswer(R.string.planet_mercury));
        binding.btnVenus.setOnClickListener(v -> checkAnswer(R.string.planet_venus));
        binding.btnEarth.setOnClickListener(v -> checkAnswer(R.string.planet_earth));
        binding.btnMars.setOnClickListener(v -> checkAnswer(R.string.planet_mars));
        binding.btnJupiter.setOnClickListener(v -> checkAnswer(R.string.planet_jupiter));
        binding.btnSaturn.setOnClickListener(v -> checkAnswer(R.string.planet_saturn));
        binding.btnUranus.setOnClickListener(v -> checkAnswer(R.string.planet_uranus));
        binding.btnNeptune.setOnClickListener(v -> checkAnswer(R.string.planet_neptune));
    }

    private void checkAnswer(int selectedPlanetResId) {
        binding.tvResult.setVisibility(View.VISIBLE);
        if (selectedPlanetResId == question.getCorrectAnswerPlanetResId()) {
            String detailText = getString(question.getDetailResId());
            String resultText = getString(R.string.result_correct_format, detailText);
            binding.tvResult.setText(resultText);
        } else {
            binding.tvResult.setText(R.string.result_wrong);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
