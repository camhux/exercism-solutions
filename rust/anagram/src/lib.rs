use std::collections::HashMap;

pub fn anagrams_for<'a>(target: &'a str, candidates: &[&'a str])
    -> Vec<&'a str> {

    let mut target_char_map = HashMap::new();

    for letter in target.chars() {
        let letter = char_to_lowercase(letter.clone());

        let ct = target_char_map
            .entry(letter.clone())
            .or_insert(0);

        *ct += 1;
    }

    candidates.into_iter().filter(|&s| {
        if *s.to_lowercase() == target.to_lowercase() {return false};

        let mut target_char_map = target_char_map.clone();

        for letter in s.chars() {
            let letter = char_to_lowercase(letter);

            match target_char_map.get_mut(&letter) {
                Some(ct) => *ct -= 1,
                None => return false,
            }

            match target_char_map.get(&letter) {
                Some(&0) => {
                    target_char_map.remove(&letter);
                },
                Some(_) => {},
                None => {},
            }
        }

        target_char_map.is_empty()
    }).cloned().collect()
}

fn char_to_lowercase(letter: char) -> char {
    letter.to_lowercase().next().expect("Failed to unwrap letter!")
}
