document.addEventListener("DOMContentLoaded", function() {
    const brand = document.querySelector("body > header > h1")
    brand.addEventListener("click", function() {
        // redirect to home page
        window.location.href = "/notesapp";
    });
});