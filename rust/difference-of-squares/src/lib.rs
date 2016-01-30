pub fn square_of_sum(n: i64) -> i64 {
    let sum = (1..(n+1)).fold(0, |acc, x| acc + x);
    sum * sum
}

pub fn sum_of_squares(n: i64) -> i64 {
    (1..(n+1)).map(|x| x * x).fold(0, |acc, x| acc + x)
}

pub fn difference(n: i64) -> i64 {
   square_of_sum(n) - sum_of_squares(n)
}
