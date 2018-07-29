val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund", "Scottish Terrier", "Great Dane", 
                     "Water Dog")
for {
  breed <- dogBreeds
  breedCaps = breed.toUpperCase()
} println(breedCaps)

val moreBreeds = List(Some("Labrador"), None, Some("Retriever"), Some("Collie"), None, Some("Husky"))
println("First pass:")
for {
  breedOption <- moreBreeds
  breed <- breddOption
  breedCaps = breed.toUpperCase()
} println(breedCaps)

println("Second pass:")
for {
  Some(breed) <- moreBreeds
  breedCaps = breed.toUpperCase()
} println(breedCaps)

