<template>
  <div class="page">
    <Navbar />
    <div class="page-wrapper">
      <div class="page-header d-print-none">
        <div class="container-xl">
          <div class="row g-2 align-items-center">
            <div class="col">
              <h2 class="page-title">TR Book store</h2>
            </div>
            <div class="col-auto ms-auto d-print-none">
              <button
                class="btn btn-primary"
                data-bs-toggle="modal"
                data-bs-target="#modalCreateBook"
              >
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  class="icon"
                  width="24"
                  height="24"
                  viewBox="0 0 24 24"
                  stroke-width="2"
                  stroke="currentColor"
                  fill="none"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                >
                  <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                  <path d="M12 5l0 14"></path>
                  <path d="M5 12l14 0"></path>
                </svg>
                Thêm sách
              </button>
            </div>
          </div>
        </div>
      </div>
      <div class="page-body">
        <div class="container-xl">
          <div class="row row-cards">
            <div class="col-12">
              <div class="card">
                <div class="card-header">
                  <h3 class="card-title">Sách</h3>
                </div>

                <div class="table-responsive">
                  <table
                    class="table card-table table-vcenter text-nowrap datatable"
                  >
                    <thead>
                      <tr>
                        <th class="w-1">ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th style="display: none">AuthorId</th>
                        <th>Publisher</th>
                        <th>ISBN</th>
                        <th>Genre</th>
                        <th>Pages</th>
                        <th>Price</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr v-for="book in books" :key="book.id">
                        <td>{{ book.id }}</td>
                        <td>{{ book.title }}</td>
                        <td>{{ book.authorEntity.name }}</td>
                        <td style="display: none">{{ book.authorEntity.id }}</td>
                        <td>{{ book.publisher }}</td>
                        <td>{{ book.isbn }}</td>
                        <td>{{ book.genre }}</td>
                        <td>{{ book.pages_count }}</td>
                        <td>{{ book.price }}</td>
                        <td class="text-end">
                          <span class="d-sm-inline">
                            <a
                              class="btn btn-danger btn-icon"
                              data-toggle="tooltip"
                              data-placement="bottom"
                              title="Xóa sách"
                              onclick="return confirm('Are you sure?')"
                            >
                              <svg
                                xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-trash"
                                width="24"
                                height="24"
                                viewBox="0 0 24 24"
                                stroke-width="2"
                                stroke="currentColor"
                                fill="none"
                                stroke-linecap="round"
                                stroke-linejoin="round"
                              >
                                <path
                                  stroke="none"
                                  d="M0 0h24v24H0z"
                                  fill="none"
                                />
                                <path d="M4 7l16 0" />
                                <path d="M10 11l0 6" />
                                <path d="M14 11l0 6" />
                                <path
                                  d="M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12"
                                />
                                <path
                                  d="M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3"
                                />
                              </svg>
                            </a>
                          </span>
                          <a
                            href="#"
                            class="btn btn-info btn-icon"
                            data-toggle="tooltip"
                            data-placement="bottom"
                            title="Sửa sách"
                            data-bs-toggle="modal"
                            data-bs-target="#modalEditBook"
                          >
                            <svg
                              xmlns="http://www.w3.org/2000/svg"
                              class="icon icon-tabler icon-tabler-edit"
                              width="24"
                              height="24"
                              viewBox="0 0 24 24"
                              stroke-width="2"
                              stroke="currentColor"
                              fill="none"
                              stroke-linecap="round"
                              stroke-linejoin="round"
                            >
                              <path
                                stroke="none"
                                d="M0 0h24v24H0z"
                                fill="none"
                              />
                              <path
                                d="M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1"
                              />
                              <path
                                d="M20.385 6.585a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3l8.385 -8.415z"
                              />
                              <path d="M16 5l3 3" />
                            </svg>
                          </a>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div
    class="modal modal-blur fade"
    id="modalCreateBook"
    tabindex="-1"
    style="display: none"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
      <form
        class="modal-content"
      >
        <div class="modal-header">
          <h5 class="modal-title">Thêm mới sách</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body row row-cards">
          <div class="col-md-6">
            <div class="mb-3">
              <label for="bookTitle" class="form-label">Tên sách</label>
              <input
                v-model="title"
                id="bookTitle"
                type="text"
                class="form-control"
                placeholder="Nhập tên sách"
                name="title"
              />
            </div>

            <div class="mb-3">
              <label for="authorId" class="form-label required"
                >Chọn tác giả</label
              >
              <select  class="form-select" v-model="authorId" id="authorId" name="authorId">
                <option value="" selected disabled>Danh sách tác giả</option>
                <option v-for="author in authors" :key="author.id" :value="author.id">{{ author.name }}</option>
              </select>
            </div>
            <div class="mb-3">
              <label for="publisher" class="form-label">Nhà xuất bản</label>
              <input
                v-model="publisher"
                id="publisher"
                type="text"
                class="form-control"
                placeholder="Nhập tên nhà xuất bản"
                name="publisher"
              />
            </div>
            <div class="mb-3">
              <label for="isbn" class="form-label">Mã ISBN</label>
              <input
                v-model="isbn"
                id="isbn"
                type="text"
                class="form-control"
                placeholder="Nhập mã isbn"
                name="isbn"
              />
            </div>
          </div>
          <div class="col-md-6">
            <div class="mb-3">
              <label for="genre" class="form-label">Thể loại</label>
              <input
                v-model="genre"
                id="genre"
                type="text"
                class="form-control"
                placeholder="Nhập thể loại sách"
                name="genre"
              />
            </div>
            <div class="mb-3">
              <label for="pages_count" class="form-label">Số trang</label>
              <input
                v-model="pages_count"
                id="pages_count"
                type="number"
                class="form-control"
                placeholder="Nhập số trang"
                name="pages_count"
              />
            </div>
            <div class="mb-3">
              <label for="price" class="form-label">Giá</label>
              <input
                v-model="price"
                id="price"
                type="number"
                class="form-control"
                placeholder="Nhập giá"
                name="price"
              />
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <a
            href="#"
            class="btn btn-link link-secondary"
            data-bs-dismiss="modal"
          >
            Cancel
          </a>
          <a @click="submitForm()" class="btn btn-primary ms-auto">
            Tạo mới
          </a>
        </div>
      </form>
    </div>
  </div>
  <div
    class="modal modal-blur fade"
    id="modalEditBook"
    tabindex="-1"
    style="display: none"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
      <form class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Edit Book Infor</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body row row-cards">
          <div class="mb-3" style="display: none">
            <input type="text" id="editbookId" name="id" />
          </div>
          <div class="col-md-6">
            <div class="mb-3">
              <label for="editbookTitle" class="form-label">Tên sách</label>
              <input
                
                id="editbookTitle"
                type="text"
                class="form-control"
                placeholder="Nhập tên sách"
                name="title"
              />
            </div>

            <div class="mb-3">
              <label for="editauthorId" class="form-label required"
                >Chọn tác giả</label
              >
              <select class="form-select" id="editauthorId" name="authorId">
                <option value="" selected disabled>Danh sách tác giả</option>
              </select>
            </div>
            <div class="mb-3">
              <label for="editpublisher" class="form-label">Nhà xuất bản</label>
              <input
                
                id="editpublisher"
                type="text"
                class="form-control"
                placeholder="Nhập tên nhà xuất bản"
                name="publisher"
              />
            </div>
            <div class="mb-3">
              <label for="editisbn" class="form-label">Mã ISBN</label>
              <input
               
                id="editisbn"
                type="text"
                class="form-control"
                placeholder="Nhập mã isbn"
                name="isbn"
              />
            </div>
          </div>
          <div class="col-md-6">
            <div class="mb-3">
              <label for="editgenre" class="form-label">Thể loại</label>
              <input
                id="editgenre"
                type="text"
                class="form-control"
                placeholder="Nhập thể loại sách"
                name="genre"
              />
            </div>
            <div class="mb-3">
              <label for="editpages_count" class="form-label">Số trang</label>
              <input
                id="editpages_count"
                type="number"
                class="form-control"
                placeholder="Nhập số trang"
                name="pages_count"
              />
            </div>
            <div class="mb-3">
              <label for="editprice" class="form-label">Giá</label>
              <input
                id="editprice"
                type="number"
                class="form-control"
                placeholder="Nhập giá"
                name="price"
              />
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <a
            href="#"
            class="btn btn-link link-secondary"
            data-bs-dismiss="modal"
          >
            Cancel
          </a>
          <input class="btn btn-primary ms-auto" type="submit" value="Update" />
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import Navbar from "@/components/Navbar.vue";
import { useToast } from "vue-toastification";
export default {
  name: "AdBooksManager",
  components: {
    Navbar,
  },
  setup() {
    const toast = useToast();
    return { toast };
  },
  async mounted() {
    try {
      const result = await axios.get("/api/books/detail");
      this.books = result.data;
      const authorsResult = await axios.get("/api/authors")
      this.authors = authorsResult.data;
    
      console.log(this.books, "books");
      console.log(this.authors,"authors")
    } catch (error) {
      console.log("mounted hook error: " + error);
    }
  },
  data() {
    return {
      authors: [],
      books: [],
      title: "",
      publisher: "",
      isbn: "",
      authorId: "",
      genre: "",
      pages_count: "",
      price: ""

    };
  },
  methods: {
    async submitForm() {
        try {
            const data = {
              title: this.title,
              publisher: this.publisher,
              isbn: this.isbn,
              genre: this.genre,
              pages_count: this.pages_count,
              price: this.price,
              author_id: this.authorId
            }
            const result = await axios.post("/api/books", data)
            console.log(result, "create book api result")

        } catch (error) {
            console.log("submitForm method error: ", error)
        }
    }
  }
};
</script>
<style scoped></style>
