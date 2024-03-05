<script setup>
  import { useRouter } from 'vue-router';
  import { reactive, onMounted, ref } from 'vue';
  import { UploadFilled } from '@element-plus/icons-vue'

  const props = defineProps({});

  const data = reactive({
    v_model: '',
    v_model_1: '',
    v_model_2: '',
    v_model_3: '',
  });

  const value = ref('')
  const expiry_date = ref('')

  const options = [
    {
      value: 'Fruit',
      label: 'Fruit',
    },
    {
      value: 'Meat',
      label: 'Meat',
    },
    {
      value: 'Vegetable',
      label: 'Vegetable',
    },
    {
      value: 'Other',
      label: 'Other',
    },
  ]

  const router = useRouter();
  const num = ref(1)
  const handleChange = () => {
    console.log(value)
  }

  const click_upload = () => {
    alert('Success!');
  }
</script>

<template>
  <div class="flex-col page">
    <span class="font text">Please provide Ingredient details :)</span>
    <div class="flex-col group">
      <div class="flex-col">
        <span class="self-start font_2">Name</span>
        <el-input class="input mt-7 elinput" v-model="data.v_model"></el-input>
      </div>
      <div class="flex-col mt-15">
        <span class="self-start font_2">Image</span>
        <!-- <el-input class="input mt-7 elinput" v-model="data.v_model"></el-input> -->
        <el-upload
          class="upload-demo mt-7"
          drag
          action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
          multiple
        >
          <el-icon class="el-icon--upload"><upload-filled /></el-icon>
          <div class="el-upload__text">
            Drop file here or <em>click to upload</em>
          </div>
          <template #tip>
            <div class="el-upload__tip">
              jpg/png files with a size less than 500kb
            </div>
          </template>
        </el-upload>
      </div>
      <div class="flex-col mt-15">
        <span class="self-start font_2">Category</span>
        <!-- <el-input class="input mt-7 elinput_1" v-model="data.v_model_1"></el-input> -->
        <el-select v-model="value" placeholder="Select" style="width: 240px" class="mt-7">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </div>
      <div class="flex-col mt-15">
        <span class="self-start font_2">Quantity</span>
        <!-- <el-input class="input mt-7 elinput_2" v-model="data.v_model_2"></el-input> -->
        <el-input-number class="mt-7" v-model="num" :min="1" :max="10" @change="handleChange" />
      </div>
      <div class="flex-col mt-15">
        <span class="self-start font_2">Expiry Date</span>
        <!-- <el-input class="input mt-7 elinput_3" v-model="data.v_model_3"></el-input> -->
        <div class="block">
          <el-date-picker
            v-model="expiry_date"
            type="date"
            placeholder="Pick a day"
            :size="size"
          />
        </div>
      </div>
    </div>
    <div class="flex-col group_2">
      <div class="flex-col justify-start items-center button" @click="click_upload"><span class="font">Upload</span></div>
      <div class="flex-col justify-start items-center text-wrapper_2 mt-9"><span class="font">Delete</span></div>
    </div>
  </div>
</template>

<style scoped lang="css">
  .mt-15 {
    margin-top: 0.94rem;
  }
  .mt-7 {
    margin-top: 0.44rem;
  }
  .mt-9 {
    margin-top: 0.56rem;
  }
  .page {
    padding: 4.13rem 1.13rem 9rem 1.13rem;
    width: 100%;
    overflow-y: auto;
    overflow-x: hidden;
    height: 100%;
  }
  .font {
    font-size: 0.88rem;
    font-family: 'Heiti SC';
    line-height: 1.25rem;
    font-weight: 700;
    color: rgb(255, 255, 255);
  }
  .text {
    color: rgb(0, 0, 0);
    font-size: 1.31rem;
    line-height: 1.31rem;
  }
  .group {
    margin-top: 2.69rem;
  }
  .font_2 {
    font-size: 1rem;
    font-family: 'Heiti SC';
    line-height: 1rem;
    font-weight: 700;
    color: rgb(0, 0, 0);
  }
  .input {
    align-self: stretch;
  }
  .group_2 {
    margin-top: 7.38rem;
    padding: 0 4.69rem;
  }
  .button {
    margin-right: 0.13rem;
    padding: 0.7rem 0 0.7rem;
    background-color: rgb(0, 0, 0);
  }
  .text-wrapper_2 {
    margin-right: 0.19rem;
    padding: 0.7rem 0 0.7rem;
    background-color: rgb(213, 56, 56);
  }

  .demo-date-picker {
    display: flex;
    width: 100%;
    padding: 0;
    flex-wrap: wrap;
  }

  .demo-date-picker .block {
    padding: 30px 0;
    text-align: center;
    border-right: solid 1px var(--el-border-color);
    flex: 1;
  }

  .demo-date-picker .block:last-child {
    border-right: none;
  }

  .demo-date-picker .demonstration {
    display: block;
    color: var(--el-text-color-secondary);
    font-size: 14px;
    margin-bottom: 20px;
  }
</style>