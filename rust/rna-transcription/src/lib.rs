use std::convert::AsRef;

#[derive(Debug, PartialEq, Eq)]
pub struct RibonucleicAcid {
    rna_string: String,
}

impl RibonucleicAcid {

    pub fn new(rna_string: &str) -> Self {
        RibonucleicAcid { rna_string: rna_string.to_string() }
    }

}

impl AsRef<str> for RibonucleicAcid {

    fn as_ref(&self) -> &str {
        self.rna_string.as_ref()
    }

}

#[derive(Debug, PartialEq, Eq)]
pub struct DeoxyribonucleicAcid {
    dna_string: String,
}

impl DeoxyribonucleicAcid {

    pub fn new(dna_string: &str) -> Self {
        DeoxyribonucleicAcid { dna_string: dna_string.to_string() }
    }

    pub fn to_rna(&self) -> RibonucleicAcid {
        let mut transcribed = String::new();

        for c in self.dna_string.chars() {
            let next = match c {
                'G' => 'C',
                'C' => 'G',
                'T' => 'A',
                'A' => 'U',
                _ => 'C',
            };

            transcribed.push(next);
        }

        RibonucleicAcid::new(&transcribed)
    }
}
