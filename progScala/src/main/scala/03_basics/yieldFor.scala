val dogBreeds = List("Doberman", "Yorkshire Terrier", "Dachshund", "Scottish Terrier", "Great Dane", 
                     "Water Dog")
val filteredBreeds = for {
  breed <- dogBreeds
  if breed.contains("Terrier") && !breed.startsWith("Yorkshire")
} yield breed
