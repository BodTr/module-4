<template>
  <div class="page">
    <Header />
    <div class="page-wrapper">
      <div class="page-body">
        <div class="container-xl">
          <div class="row row-cards">
            <Book v-for="book in books" :key="book.id" :book="book" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from '@/components/Header.vue';
import Book from '@/components/Book.vue';
export default {
  name: "ClBookList",
  components: {
    Header,
    Book
  },
  data() {
    return {
      books: [
        // {
        //   id: 1,
        //   title: "The Great Gatsby",
        //   author: "F. Scott Fitzgerald",
        //   price: 10.99,
        //   cover: "/src/assets/photos/the_great_gatsby.jpg",
        // },
        // {
        //   id: 2,
        //   title: "To Kill a Mockingbird",
        //   author: "Harper Lee",
        //   price: 12.99,
        //   cover: "/src/assets/photos/to_kill_a_mocking_bird.jpg",
        // },
        // {
        //   id: 3,
        //   title: "Harry Potter and the Cursed Child",
        //   author: "J.K Rolling",
        //   price: 22.99,
        //   cover: "/src/assets/photos/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg",
        // },
        // {
        //   id: 4,
        //   title: "The Great Gatsby",
        //   author: "F. Scott Fitzgerald",
        //   price: 10.99,
        //   cover: "/src/assets/photos/the_great_gatsby.jpg",
        // },
        // {
        //   id: 5,
        //   title: "To Kill a Mockingbird",
        //   author: "Harper Lee",
        //   price: 12.99,
        //   cover: "/src/assets/photos/to_kill_a_mocking_bird.jpg",
        // },
        // {
        //   id: 6,
        //   title: "Harry Potter and the Cursed Child",
        //   author: "J.K Rolling",
        //   price: 22.99,
        //   cover: "/src/assets/photos/Harry_Potter_and_the_Cursed_Child_Special_Rehearsal_Edition_Book_Cover.jpg",
        // },
        
      ],
    }
  },
  async mounted() {
    try {
      const result = await axios.get("/api/books");
      this.books = result.data;
      console.log(this.books, "books");
    } catch (error) {
      console.log("get books api error: " + error);
    }
  }
  
}
</script>

<style scoped>

</style>