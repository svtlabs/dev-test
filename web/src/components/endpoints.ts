export const endpoints = {
    characters: 'http://localhost:8080/api/characters',
    people: (id: string) => `http://localhost:8080/api/characters/people/${id}`,
    films: (filmId: string) => `http://localhost:8080/api/characters/films/${filmId}`,
    species: (speciesId: string) => `http://localhost:8080/api/characters/species/${speciesId}`,
    starships: (starshipId: string) => `http://localhost:8080/api/characters/starships/${starshipId}`,
    planets: (planetId: string) => `http://localhost:8080/api/characters/planets/${planetId}`,
    vehicles: (vehicleId: string) => `http://localhost:8080/api/characters/vehicles/${vehicleId}`
}