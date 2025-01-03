package com.anagram.challenge.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnagramService {

    public List<String> generateAnagrams(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result; // Retorna vazio se o input for inválido
        }
        permute(input.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] array, int index, List<String> result) {
        if (index == array.length - 1) {
            result.add(new String(array)); // Adiciona a permutação à lista
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, index, i); // Troca os caracteres
            permute(array, index + 1, result); // Recursão
            swap(array, index, i); // Backtracking para restaurar o estado original
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

