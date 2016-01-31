pub fn hamming_distance(a: &str, b: &str) -> Result<usize, &'static str> {
    if a.len() != b.len() {return Result::Err("inputs of different length")}

    let mut distance = 0;
    let pairs = a.chars().zip(b.chars());

    for (char_a, char_b) in pairs {
        if char_a != char_b {
            distance += 1;
        }
    }

    Result::Ok(distance)
}