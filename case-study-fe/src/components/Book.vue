<template>
  <div class="col-sm-6 col-lg-4">
    <div class="card card-sm">
    <a href="#" class="d-block"
      ><img
        src="../assets/photos/the_great_gatsby.jpg"
        alt="Book Cover"
        class="card-img-top"
    /></a>
    <div class="card-body">
      <div>
        <h3>{{ book.title }}</h3>
        <p> {{ book.author }} </p>
        <p>{{ book.price }}$</p>
      </div>
    </div>
  </div>
  </div>

</template>

<script>
  export default {
    name: "Book",
    props: {
      book: {
        type: Object,
        required: true
      }
    },
    data() {
      return {
        
      }
    }
  }
</script>
