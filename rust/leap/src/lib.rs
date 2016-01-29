pub fn is_leap_year(year: usize) -> bool {
    (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}
