<template>
  <div class="page">
    <Navbar />
    <div class="page-wrapper">
      <div class="page-header d-print-none">
        <div class="container-xl">
          <div class="row g-2 align-items-center">
            <div class="col">
              <h2 class="page-title">Thống kê đơn hàng</h2>
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
                Thêm mới
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
                <!-- <div class="card-header">
                  <h3 class="card-title">Sách</h3>
                </div> -->

                <div class="table-responsive">
                  <table
                    class="table card-table table-vcenter text-nowrap datatable"
                  >
                    <thead>
                      <tr>
                        <th class="w-1">Mã đơn hàng</th>
                        <th>Tên sản phẩm</th>
                        <th style="display: none">ItemId</th>
                        <th>Giá (USD)</th>
                        <th>Loại sản phẩm</th>
                        <th style="display: none">ItemTypeId</th>
                        <th>Ngày mua</th>
                        <th>Số Lượng</th>
                        <th>Tổng tiền (USD)</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr v-for="order in orders" :key="order.id">
                        <td>{{ order.id }}</td>
                        <td>{{ order.itemEntity.name }}</td>
                        <td style="display: none">{{ order.itemEntity.id }}</td>
                        <td>{{ order.itemEntity.price }}</td>
                        <td>{{ order.itemEntity.itemType.name }}</td>
                        <td style="display: none">{{ order.itemEntity.itemType.id }}</td>
                        <td>{{ order.orderDate }}</td>
                        <td>{{ order.itemCount }}</td>
                        <td>{{ order.itemCount * order.itemEntity.price }}</td>
                        <td class="text-end">
                          <a
                            href="#"
                            class="btn btn-info btn-icon"
                            data-toggle="tooltip"
                            data-placement="bottom"
                            title="Sửa order"
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
          <h5 class="modal-title">Thêm mới order</h5>
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
              <label for="bookTitle" class="form-label">Tên sản phẩm</label>
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
// import { useToast } from "vue-toastification";
export default {
  name: "OrdersManager",
  components: {
    Navbar,
  },
  // setup() {
  //   const toast = useToast();
  //   return { toast };
  // },
  async mounted() {
    try {
      const result = await axios.get("/api/orders");
      this.orders = result.data;
      const itemsResult = await axios.get("/api/items")
      this.items = authorsResult.data;
      
      console.log(this.books, "orders");
      console.log(this.authors,"items")
    } catch (error) {
      console.log("mounted hook error: " + error);
    }
  },
  data() {
    return {
      items: [],
      orders: [],
      itemId: "",
      itemPrice: "",
      itemTypeId: "",
      buyDate: "",
      count: "",
      totalMoney: "",

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
