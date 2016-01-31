#[derive(PartialEq, Debug, Clone)]
pub enum Allergen {
    Eggs,
    Peanuts,
    Shellfish,
    Strawberries,
    Tomatoes,
    Chocolate,
    Pollen,
    Cats,
}

pub fn get_all_allergens() -> Vec<Allergen> {
    vec![Allergen::Eggs, Allergen::Peanuts, Allergen::Shellfish,
         Allergen::Strawberries, Allergen::Tomatoes, Allergen::Chocolate,
         Allergen::Pollen, Allergen::Cats]
}

pub struct Allergies(pub u8);

impl Allergies {

    pub fn is_allergic_to(&self, allergen: &Allergen) -> bool {
        (self.0 & 1 << (allergen.clone() as u8)) > 0
    }

    pub fn allergies(&self) -> Vec<Allergen> {
        get_all_allergens()
            .into_iter()
            .filter(|a| self.is_allergic_to(a))
            .collect()
    }

}
