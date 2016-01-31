use std::collections::HashMap;

struct NucleotideMap(HashMap<char, usize>);

impl NucleotideMap {
    fn new() -> Self {
        let mut map = HashMap::new();
        for c in ['A', 'T', 'C', 'G'].into_iter() {
            map.insert(*c, 0);
        }
        NucleotideMap(map)
    }
}

pub fn count(nucleotide: char, dna_string: &str) -> usize {
    let mut count = 0;

    for c in dna_string.chars() {
        if c == nucleotide {
            count += 1;
        }
    }

    count
}

pub fn nucleotide_counts(dna_string: &str) -> HashMap<char, usize> {
    let NucleotideMap(mut counts) = NucleotideMap::new();

    for c in dna_string.chars() {
        if let Some(mut count) = counts.get_mut(&c) {
            *count += 1;
        }
    }

    counts
}
