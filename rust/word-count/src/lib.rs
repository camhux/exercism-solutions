use std::collections::HashMap;

pub fn word_count(sentence: &str) -> HashMap<String, u32> {
    let mut word_buffer: String = String::new();
    let mut counts = HashMap::new();

    for c in sentence.chars() {
        if c.is_alphanumeric() {
            word_buffer.push_str(&expand_lowercase(c));
        } else {
            count_word(&mut word_buffer, &mut counts);
        }
    }

    count_word(&mut word_buffer, &mut counts);
    counts
}

fn count_word(word: &mut String, counts: &mut HashMap<String, u32>) {
    if !word.is_empty() {
        let mut count = counts.entry(word.clone()).or_insert(0);
        *count += 1;
        word.clear();
    }
}

fn expand_lowercase(c: char) -> String {
    let mut s = String::new();
    for next_char in c.to_lowercase() {
        s.push(next_char);
    }
    s
}
