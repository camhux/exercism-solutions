pub fn hello(name: Option<&str>) -> String {
    match name {
        Some(name) => {format!("Hello, {}!", name)},
        None => {format!("Hello, World!")},
    }
}
